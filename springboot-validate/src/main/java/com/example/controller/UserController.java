package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jameszhou
 */
@Slf4j
@RestController
public class UserController {

    @PostMapping("/user/add")
    public String addUser(@Validated @RequestBody User user, BindingResult result) {
        log.info("user = {}", user);
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return JSON.toJSONString(list);
        }
        return "success";
    }
}
