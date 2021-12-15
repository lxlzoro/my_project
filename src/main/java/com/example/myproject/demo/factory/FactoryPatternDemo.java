package com.example.myproject.demo.factory;

import com.example.myproject.common.Constant;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape(Constant.CIRCLE);
        circle.draw();

        Shape square = shapeFactory.getShape(Constant.SQUARE);
        square.draw();

        Shape rectangle = shapeFactory.getShape(Constant.RECTANGLE);
        rectangle.draw();
    }
}
