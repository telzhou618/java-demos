package com.example.decorator;

/**
 * @author zhougaojun
 */
public class CircleShape implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape：Circle");
    }
}
