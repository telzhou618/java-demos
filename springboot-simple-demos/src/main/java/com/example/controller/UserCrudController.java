package com.example.controller;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zhougaojun
 */
@RestController
@AllArgsConstructor
public class UserCrudController {

    private UserMapper userMapper;

    @GetMapping("/user/list")
    public List<User> userList() {
        return userMapper.selectAll();
    }

    @PostMapping("/user/add")
    public void addUser(@Validated @RequestBody User user) {
        userMapper.insertSelective(user);
    }

    @GetMapping("/user/get")
    public User getUser(@NotNull(message = "用户ID不能为空") Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @GetMapping("/user/exception")
    public void userException() {
        System.out.println(1 / 0);
    }
}
