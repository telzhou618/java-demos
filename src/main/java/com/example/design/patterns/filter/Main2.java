package com.example.design.patterns.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zhougaojun
 */
public class Main2 {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User().setAge(12).setName("zhougaojun"));
        userList.add(new User().setAge(8).setName("lisi"));
        userList.add(new User().setAge(18).setName("zhangsan"));
        userList.add(new User().setAge(11).setName("zhoutao"));

        userList.stream()
                .filter(ageFilter)
                .filter(nameFilter)
                .forEach(System.out::println);
    }

    private static Predicate<User> ageFilter = o -> o.getAge() > 10;
    private static Predicate<User>  nameFilter = o -> o.getName().contains("zhou");
}
