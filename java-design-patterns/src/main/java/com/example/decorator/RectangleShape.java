package com.example.decorator;

/**
 * @author zhougaojun
 */
public class RectangleShape implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape：Rectangle");
    }
}
