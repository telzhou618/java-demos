package com.example.decorator;

/**
 * @author zhougaojun
 */
public class Main {

    public static void main(String[] args) {
        Shape shape = new CircleShape();
        RadColorShapeDecorator shapeDecorator = new RadColorShapeDecorator(shape);
        shapeDecorator.draw();
    }
}
