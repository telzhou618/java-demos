package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhougaojun
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Cat extends Animal{
    private String color;
}
