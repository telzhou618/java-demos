package com.example.design.patterns.decorator;

/**
 * @author zhougaojun
 */
public class Main {

    public static void main(String[] args) {
        Shape shape = new CircleShape();
        shape = new RadColorShapeDecorator(shape);
        shape.draw();
    }
}
