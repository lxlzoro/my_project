package com.example.myproject.entity;

import lombok.Data;

@Data
public class TPersonInfo {
    private int id;
    private String name ;
    private int age;
    private int sex;
    private String address;

    public TPersonInfo(String name, int age, int sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }
}
