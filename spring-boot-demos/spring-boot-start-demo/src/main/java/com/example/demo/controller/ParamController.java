package com.example.demo.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @description: ParamController
 * @author: zhougaojun
 * @date: 2019/07/02
 */
@RestController
@RequestMapping("/param")
public class ParamController {

    @PostMapping("/post")
    public String test(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return "ok";
    }

    @PostMapping("/post2")
    public String test2(String name,int age) {
        System.out.println(name);
        System.out.println(age);
        return "ok";
    }


    @Data
    public static class UserDTO {
        private String name;
        private int age;
    }
}
