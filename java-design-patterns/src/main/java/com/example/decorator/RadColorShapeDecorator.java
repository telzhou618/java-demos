package com.example.decorator;

/**
 * @author zhougaojun
 */
public class RadColorShapeDecorator implements Shape {

    private Shape shape;

    public RadColorShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
        radColor();
    }

    private void radColor() {
        System.out.println("Color: rad");
    }
}
