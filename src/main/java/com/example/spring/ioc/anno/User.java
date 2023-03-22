package com.example.spring.ioc.anno;

public class User {
    private Integer userId;
    private String username;

    public User() {
    }

    public User(Integer userId, String username) {
        this.userId = userId;
        this.username = username;
    }
}
