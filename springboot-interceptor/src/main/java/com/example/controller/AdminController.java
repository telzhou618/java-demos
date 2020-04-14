package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jameszhou
 */
@RestController
public class AdminController {

    @RequestMapping("/admin/add")
    public String add() {
        System.out.println("add 有权限执行！");
        return "add success";
    }

    @RequestMapping("/test")
    public String test() {
        return "test success";
    }
}
