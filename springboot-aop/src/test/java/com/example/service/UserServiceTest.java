package com.example.service;

import com.example.SpringTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserServiceTest extends SpringTests {

    @Autowired
    private UserService userService;
    @Test
    void listALl() {
        System.out.println(userService.listALl());
    }

}