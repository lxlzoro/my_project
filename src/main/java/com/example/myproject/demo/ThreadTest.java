package com.example.myproject.demo;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * @author liuxiaolei
 * @date 2021/12/17 11:19
 * @description：线程测试类Demo
 */
public class ThreadTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,4,200, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2));
        for (int i = 0; i < 5; i++) {
            MyRunnable myRunnable = new MyRunnable();
            //执行任务并且获取Future对象
            threadPoolExecutor.submit(myRunnable);
        }
        //关闭线程池
        threadPoolExecutor.shutdown();
        System.out.println("主线程for循环执行完毕。。");

    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("通过线程池的方式创建线程：" + Thread.currentThread().getName() + " ");
        }
    }
}
