package com.example.spring.ioc.anno;

import com.google.common.collect.Lists;

import java.util.List;

@Component
public class UserDao {

    public List<User> getUsers() {
        return Lists.newArrayList(new User(1, "zhangsan"));
        // fetch users from database
    }
}

