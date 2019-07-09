package com.demo.service;

import com.demo.entitry.Post;

import java.util.List;

/**
 * @author: zhougaojun
 * @date: 2019/05/21
 * @description:
 */
public interface PostService {
    /**
     *  查询点赞数前100
     * @param num
     * @return
     */
    List<Post> getPostTopByVotes(int num);
}
