package com.demo;

import com.demo.entitry.Post;
import com.demo.repository.PostRepository;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author: zhougaojun
 * @date: 2019/05/22
 * @description:
 */
public class PostTest extends SpringBootTests {

    @Resource
    private PostRepository postRepository;
    @Resource
    RedisTemplate<String, Post> redisTemplate;

    private static final String POSTS_KET = "post_zsets";

    @Test
    public void testMySQLTop100() {
        long curTime = System.currentTimeMillis();
        postRepository.findTopByVotes(100).stream().forEach(System.out::println);
        System.out.println("Posts.MySQLTop100 耗时 = " + (System.currentTimeMillis() - curTime) + "ms");
    }

    @Test
    public void testRedisTop100() {
        long curTime = System.currentTimeMillis();
        redisTemplate.opsForZSet().reverseRange(POSTS_KET, 0, 100).stream().forEach(System.out::println);
        System.out.println("Post.RedisTop100 耗时 = " + (System.currentTimeMillis() - curTime) + "ms");
    }
}
