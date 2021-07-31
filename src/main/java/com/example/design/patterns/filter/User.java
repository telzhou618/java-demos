package com.example.design.patterns.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author zhougaojun
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class User {

    private Integer id;
    private String name;
    private int age;
}
