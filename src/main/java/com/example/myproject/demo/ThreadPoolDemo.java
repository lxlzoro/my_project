package com.example.myproject.demo;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * create by: lxl
 * description: 线程池demo
 * create time: 13:37 2021/12/16
 */
public class ThreadPoolDemo {
    private static final int CORE_POOL_SIZE = 1;
    private static final int MAXIMUM_POOL_SIZE = 1;
    private static final long KEEP_ALIVE_TIME = 500L;
    private static final int BLOCKING_QUEUE_SIZE = 2;
    private static BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(BLOCKING_QUEUE_SIZE);

    private static  ThreadPoolExecutor threadPoolExecutor ;

    private static final ThreadPoolDemo instance = new ThreadPoolDemo();


    public static ThreadPoolDemo getInstance() {
        if (threadPoolExecutor.isShutdown()){
            threadPoolExecutor= new ThreadPoolExecutor(CORE_POOL_SIZE,MAXIMUM_POOL_SIZE,KEEP_ALIVE_TIME,TimeUnit.SECONDS,blockingQueue);
        }
        return instance;
    }










}
