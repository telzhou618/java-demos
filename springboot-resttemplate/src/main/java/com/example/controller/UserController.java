package com.example.controller;

import com.example.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhougaojun
 */
@Slf4j
@RestController
public class UserController {
    /**
     * 普通表单提交
     */
    @PostMapping("/user/form/add")
    public User addForm(User user) {
        log.info("add,user={}", user);
        return user;
    }

    /**
     * json 提交
     */
    @PostMapping("/user/json/add")
    public User addJson(@RequestBody User user) {
        log.info("add,user={}", user);
        return user;
    }

    /**
     * 500 错误
     */
    @GetMapping("/error/500")
    public String error(@RequestBody User user) {
        System.out.println(1 / 0);
        return "ok";
    }
}
