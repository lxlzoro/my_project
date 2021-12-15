package com.example.myproject.demo.builder;

/**
 * create by: lxl
 * description: TODO
 * create time: 16:27 2021/12/15
 */
public abstract  class Burger implements Item {
    @Override
    public String name() {
        return null;
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
