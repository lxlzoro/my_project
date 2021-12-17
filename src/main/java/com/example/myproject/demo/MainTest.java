package com.example.myproject.demo;

public class MainTest {

    public static void main(String[] args) {
        for (int i=1;i<5;i++){

            int finalI = i;
            ThreadPoolDemo.getInstance().submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第"+ finalI +"个数据");
                }
            });
        }
    }
}
