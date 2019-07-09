package com.demo.redis;

import org.junit.Test;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: zhougaojun
 * @date: 2019/06/03
 * @description:
 */
public class RedissonTest extends SpringTests {

    @Autowired
    private RedissonClient redisson;

    @Test
    public void testList() {
        RList<String> list = redisson.getList("strList");
        System.out.println(list.add("hello world"));
    }

    @Test
    public void testList2() {
        RList<String> list = redisson.getList("strList");
        System.out.println(list.get(0));
    }

    @Test
    public void testList3() {
        RList<String> list = redisson.getList("strList");
        System.out.println(list.remove(0));
    }
}
