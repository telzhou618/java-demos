package com.dxy.redis;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisCluster;

/**
 * @author: zhougaojun
 * @date: 2019/05/29
 * @description:
 */
public class LettuceRedisClusterTest extends SpringTests {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testSet() {
        redisTemplate.opsForValue().set("name", "zhangsan");
    }

    @Test
    public void testGet() {
        String value = redisTemplate.opsForValue().get("name");
        System.out.println(value);
    }
}
