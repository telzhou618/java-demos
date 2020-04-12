package com.example;

import com.alibaba.fastjson.JSON;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author jameszhou
 */
@Slf4j
@SpringBootTest
class SpringTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testList() {
        log.info(JSON.toJSONString(userMapper.selectAll()));
    }

    @Test
    public void add() {
        User user = new User()
                .setUsername("abc")
                .setPassword("123");
        int res = userMapper.insertSelective(user);
        Assertions.assertTrue(res > 0);
    }

    @Test
    public void update() {
        User user = new User()
                .setId(5)
                .setUsername("abc")
                .setPassword("456");
        int res = userMapper.updateByPrimaryKey(user);
        Assertions.assertTrue(res > 0);
    }
    @Test
    public void delete() {
        int res = userMapper.deleteByPrimaryKey(4);
        Assertions.assertTrue(res > 0);
    }
}
