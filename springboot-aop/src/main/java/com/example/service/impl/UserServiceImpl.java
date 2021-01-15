package com.example.service.impl;

import com.example.entity.User;
import com.example.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhougaojun
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<User> listALl() {
        return Lists.newArrayList(
                new User().setId(1).setUsername("tom").setPassword("123456"),
                new User().setId(2).setUsername("lucy").setPassword("123456")
        );
    }
}
