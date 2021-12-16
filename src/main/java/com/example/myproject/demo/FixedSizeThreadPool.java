package com.example.myproject.demo;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 一个线程池的demo
 */
@Log4j2
public class FixedSizeThreadPool {
    /**
     * 线程池的准备 一个仓库
     */
    public BlockingQueue<Runnable> blockingQueue;
    /**
     * 一个线程的集合
     */
    public List<Thread> workers;

    // 关闭的方法：
    //a.仓库停止接收任务
    //b.一旦仓库中还有任务就要继续执行
    //c. 拿任务就不该阻塞
    //d.一旦任务阻塞，我就中断他
    private volatile boolean isWorking = true;

    /**
     * 具体干活的线程
     */
    public static class Worker extends Thread {
        // 1.到我们的仓库中去拿东西（blockingQueue）
        private FixedSizeThreadPool pool;

        //创建构造方法，声明自己属于哪个线程池
        public Worker(FixedSizeThreadPool pool) {
            this.pool = pool;
        }


        @Override
        public void run() {
            //开始工作
            while (this.pool.isWorking || this.pool.blockingQueue.size() > 0) {
                Runnable task = null;
                //从队列里拿东西需要的是阻塞

                try {
                    if (this.pool.isWorking) {
                        task = this.pool.blockingQueue.take();
                    } else {
                        task = this.pool.blockingQueue.poll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (task != null) {
                    task.run();
                    log.info("线程：{}执行完毕", Thread.currentThread().getName());
                }
            }
        }

    }

    public FixedSizeThreadPool(int poolsize, int taskSize) {
        if (poolsize <= 0 || taskSize <= 0)
            throw new IllegalArgumentException("非法参数");
        this.blockingQueue = new LinkedBlockingQueue<>(taskSize);
        this.workers = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < poolsize; i++) {
            Worker work = new Worker(this);
            work.start();
            workers.add(work);
        }

    }

    //把任务提交到仓库中的办法
    public boolean submit(Runnable task) {
        if (isWorking) {
            return this.blockingQueue.offer(task);
        } else {
            return false;
        }
    }

    public void shutDown() {
        //执行关闭即可
        this.isWorking = false;
        for (Thread thread : workers) {
            if (thread.getState().equals(Thread.State.BLOCKED)) {
                //中断线程
                thread.interrupt();

            }
        }
    }

    public static void main(String[] args) {
        FixedSizeThreadPool fixedSizeThreadPool = new FixedSizeThreadPool(3, 6);
        for (int i = 0; i < 6; i++) {
            fixedSizeThreadPool.submit(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("放入线程");
                            try {
                                Thread.sleep(2000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                log.error("一个线程被中断");
                            }
                        }
                    }
            );
        }
        fixedSizeThreadPool.shutDown();
    }

    /*
    现在随着互联网用户的激增，也就要求软件服务的反应速度的提升，多线程是常用的软件编程技术。
    现在讲讲java线程的几种常见的创建方式：
    ①继承Thread类`...extends Thread`
    ②覆写Runnable()接口
    ③覆写Callable()接口，覆写call()方法

    线程池：ThreadPoolExecutor
    线程池的构造函数参数多达7个

    corePoolSize：线程池中核心线程数的最大值
    如果ThreadPoolExecutor.execute的任务数大于corePoolSize，那么就进入队列BlockingQueue，如果BlockingQueue满了会继续创建新线程、一直到线程个数大于第二个参数maximumPoolSize。
    在刚创建ThreadPoolExecutor的时候线程不会立即启动，而是等到了有任务要执行才会启动。

	maximumPoolSize：允许创建的最大线程数、如果BlockingQueue已经满了、线程数等于maximumPoolSize 则会执行ThreadPoolExecutor的拒绝策略

	keepAliveTime：表示空闲线程的存活时间

	TimeUnit unit：表示keepAliveTime的单位

	workQueue：队列，当线程在大于核心线程数和小于最大线程数的时候，线程在队列中。

	handler：拒绝策略
	当没有多余线程执行的时候就会触发相对应的拒绝策略
	ThreadPoolExecutor.AbortPolicy()：抛出异常
	ThreadPoolExecutor.CallerRunsPolicy()：由向线程池提交任务的线程来执行该任务
	ThreadPoolExecutor.DiscardPolicy()：抛弃当前的任务
	ThreadPoolExecutor.DiscardOldestPolicy()：抛弃最旧的任务（最先提交而没有得到执行的任务）
*/

}
