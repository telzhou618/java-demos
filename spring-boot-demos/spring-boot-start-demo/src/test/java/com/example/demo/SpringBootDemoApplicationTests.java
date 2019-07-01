package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private Jedis jedis;

    @Test
    public void test() {
        System.out.println(jedis.set("name", "lisi"));
        System.out.println(jedis.get("name"));
    }

}
