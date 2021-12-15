package com.example.myproject.demo.abstractfactory;

public class Green implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
