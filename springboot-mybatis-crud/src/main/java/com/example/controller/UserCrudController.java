package com.example.controller;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhougaojun
 */
@RestController
@AllArgsConstructor
public class UserCrudController {


    private UserMapper userMapper;

    @GetMapping("/user/list")
    private List<User> userList() {
        return userMapper.selectAll();
    }

}
