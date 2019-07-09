package com.demo.controller;

import com.demo.entitry.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhougaojun
 * @date: 2019/05/24
 * @description:
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    /**
     * 点赞排行前三的用户列表
     *
     * @return
     */
    @GetMapping("/top3")
    public List<User> getTop3() {
        List<User> users = redisTemplate.opsForZSet().reverseRange("users", 0, 2)
                .stream().map(object -> (User) object)
                .collect(Collectors.toList());
        return users;
    }


    /**
     * 获取张三李四的共同好友
     *
     * @return
     */
    @GetMapping("/friend")
    public List<String> friend() {
        Long num = redisTemplate.opsForZSet().intersectAndStore("zhangSanFriends", "lisiFriends", "user_zhangsan_lisi_friends");
        return redisTemplate.opsForZSet().range("user_zhangsan_lisi_friends", 0, num)
                .stream().map(Object::toString).collect(Collectors.toList());
    }
}
