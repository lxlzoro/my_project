package com.example.myproject.demo.factory;


import com.example.myproject.common.Constant;

/**
 * create by: lxl
 * description: 创建一个工厂，生成基于给定信息的实体类的对象
 * create time: 13:40 2021/12/15
 */
public class ShapeFactory {

    /**
     * 使用 getShape方法获取形状类型的对象
     * @param shapeType
     * @return
     */
    public Shape getShape(String shapeType){
        if (shapeType==null){
            return null;
        }
        if ((Constant.CIRCLE).equalsIgnoreCase(shapeType)){
            return new Circle();
        }else if ((Constant.RECTANGLE).equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }else if((Constant.SQUARE).equalsIgnoreCase(shapeType )){
            return new Square();
        }
        return null;
    }
}
