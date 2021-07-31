package com.example.design.patterns.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhougaojun
 */
public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User().setAge(12).setName("zhougaojun"));
        userList.add(new User().setAge(8).setName("lisi"));
        userList.add(new User().setAge(18).setName("zhangsan"));
        userList.add(new User().setAge(11).setName("zhoutao"));

        List<ChainFilter<User>> filters = new ArrayList<>();
        filters.add(new NameChainFilter());
        filters.add(new AgeChainFilter());

        for (ChainFilter<User> filter : filters) {
            userList = filter.doFilter(userList);
        }
        System.out.println(userList);
    }
}
