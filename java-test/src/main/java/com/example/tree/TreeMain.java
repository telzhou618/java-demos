package com.example.tree;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhougaojun
 */
public class TreeMain {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class Post {
        private int id;
        private int parent;
        private String body;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class PostNode {
        private Post post;
        private List<Post> subPostNodes;
    }

    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();

        // posts.add(new Post(1, 0, "主帖"));

        posts.add(new Post(2, 1, "不错不错"));
        posts.add(new Post(3, 1, "可以可以"));
        posts.add(new Post(4, 1, "OK，挺好"));


        posts.add(new Post(5, 2, "用户5回复了2"));
        posts.add(new Post(6, 2, "用户6回复了2"));
        posts.add(new Post(7, 3, "用户7回复了3"));

        posts.add(new Post(8, 5, "用户8回复了5"));
        posts.add(new Post(9, 5, "用户9回复了5"));
        posts.add(new Post(10, 9, "用户10回复了9"));
        posts.add(new Post(11, 7, "用户11回复了7"));

        int rootId = 1;

        // 回帖树状列表
        List<PostNode> allReReplyPosts = posts.parallelStream()
                .filter(p -> Objects.equals(p.getParent(), rootId))
                .map(post -> new PostNode(post, new LinkedList<>())).collect(Collectors.toList());


        // 一级回帖 map
        Map<Integer, Post> oneLevelPostMap = posts.parallelStream().filter(p -> Objects.equals(p.getParent(), rootId))
                .collect(Collectors.toMap(Post::getId, Function.identity()));
        // 二级回帖 list
        List<Post> twoLevelPostList = posts.parallelStream().filter(p -> !Objects.equals(p.getParent(), rootId))
                .collect(Collectors.toList());
        // 二级回帖 map
        Map<Integer, Post> twoLevelPostMap = twoLevelPostList.parallelStream().collect(Collectors.toMap(Post::getId, Function.identity()));

        for (Post post : twoLevelPostList) {
            Post oneLevelParentPost = getOneLevelReplyPost(post, oneLevelPostMap, twoLevelPostMap);
            if (oneLevelParentPost != null) {
                allReReplyPosts.stream()
                        .filter(postNode -> Objects.equals(postNode.getPost().getId(), oneLevelParentPost.getId()))
                        .findFirst()
                        .ifPresent(o -> o.getSubPostNodes().add(post));
            }
        }

        System.out.println(JSON.toJSONString(allReReplyPosts));

    }

    /**
     * 查找一个N级回帖的一级父帖子
     */
    public static Post getOneLevelReplyPost(Post post,
                                            Map<Integer, Post> oneLevelPostMap,
                                            Map<Integer, Post> otherLevelPostMap) {

        if (post == null) {
            return null;
        }
        // 回帖的父级回帖在一级回帖，直接返回
        Post parentPost = oneLevelPostMap.get(post.getParent());
        if (parentPost != null) {
            return parentPost;
        } else {
            // 回帖的父级回帖在其他层级回帖，继续往上找，直到找到一级回帖
            Post parent = otherLevelPostMap.get(post.getParent());
            return getOneLevelReplyPost(parent, oneLevelPostMap, otherLevelPostMap);
        }

    }
}
