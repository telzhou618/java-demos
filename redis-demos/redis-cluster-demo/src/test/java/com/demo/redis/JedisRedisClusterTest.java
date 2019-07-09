package com.demo.redis;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

/**
 * @author: zhougaojun
 * @date: 2019/05/29
 * @description:
 */
public class JedisRedisClusterTest extends SpringTests {


    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void testSet() {
        String result = jedisCluster.set("name", "zhangsan");
        System.out.println(result);

    }

    @Test
    public void testGet() {
        String value = jedisCluster.get("name");
        System.out.println(value);
    }
}
