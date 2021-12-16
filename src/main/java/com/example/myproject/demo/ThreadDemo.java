package com.example.myproject.demo;

import org.apache.ibatis.io.ResolverUtil;

import java.io.IOException;

/**
 * 线程demo
 */
public class ThreadDemo {
    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args) throws IOException {
       ThreadDemo test = new ThreadDemo();    //Test为类名
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();
        thread1.start();
        thread2.start();
    }

    class MyThread extends Thread{

        @SuppressWarnings("static-access")
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("线程"+Thread.currentThread().getId()+"进入睡眠状态");
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("线程"+Thread.currentThread().getId()+"睡眠结束");
                i++;
                System.out.println("i:"+i);
            }
        }


    }
}
