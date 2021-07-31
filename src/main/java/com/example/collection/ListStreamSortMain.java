package com.example.collection;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

/**
 * 多字段排序
 *
 * @author zhougaojun
 */
public class ListStreamSortMain {

    public static void main(String[] args) {

        Lists.newArrayList(
                new User(1, 18),
                new User(2, 18),
                new User(3, 80),
                new User(4, 90),
                new User(4, 80)
        )
                .stream()
                // 先按照用户ID倒序，再按照年龄倒序
                .sorted(Comparator.comparing(User::getId, Comparator.reverseOrder())
                        .thenComparing(User::getAge, Comparator.reverseOrder()))
                .forEach(System.out::println);

    }

    @Data
    @AllArgsConstructor
    public static class User {
        private Integer id;
        private Integer age;
    }
}
