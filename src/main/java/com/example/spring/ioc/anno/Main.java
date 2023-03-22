package com.example.spring.ioc.anno;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext("/Users/zhougaojun/dxy/github/java-demos/target/classes/com/example/spring/ioc/anno");
        UserService userService = (UserService) context.getBean(UserService.class);
        List<User> userList = userService.getUsers();
        // ...
    }
}
