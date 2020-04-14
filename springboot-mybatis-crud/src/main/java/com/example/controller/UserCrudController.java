package com.example.controller;

import com.example.common.Result;
import com.example.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhougaojun
 */
@RestController
@AllArgsConstructor
public class UserCrudController {


    private UserMapper userMapper;

    @GetMapping("/user/list")
    private Result userList() {
        return Result.success(userMapper.selectAll());
    }

}
