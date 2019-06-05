package com.dxy;

import com.dxy.entitry.Post;
import com.dxy.repository.PostRepository;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.stream.IntStream;

/**
 * @author: zhougaojun
 * @date: 2019/05/21
 * @description:
 */
public class InitTest extends SpringBootTests {

    @Resource
    private PostRepository postRepository;

    @Resource
    RedisTemplate<String, Post> redisTemplate;

    private static final String POSTS_KET = "post_zsets";

    @Test
    public void initDb() {
        IntStream.range(1, 10).forEach(i -> {
            Post post = new Post();
            post.setSubject("帖子标题-" + i);
            post.setBody("帖子内容-" + i);
            post.setViews(RandomUtils.nextInt(1, 1000000));
            post.setVotes(RandomUtils.nextInt(1, 1000000));
            post.setStars(RandomUtils.nextInt(1, 1000));
            post.setReplies(RandomUtils.nextInt(1, 100000));
            post.setCreateTime(new Date());
            post.setModifyTime(new Date());
            postRepository.save(post);
        });
    }

    @Test
    public void initRedis() {
        postRepository.findAll().stream().limit(10).forEach(post -> {
            redisTemplate.opsForZSet().add(POSTS_KET, post, post.getVotes());
        });
    }
}
