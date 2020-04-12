package com.example;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@Log
@SpringBootTest
class SpringTests {

   @Autowired
   private Jedis jedis;

    @Test
    public void test(){
        jedis.set("name","tom");
        log.info(jedis.get("name"));
    }

}
