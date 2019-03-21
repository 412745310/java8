package com.chelsea.java8.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池ThreadPoolExecutor
 * CountDownLatch计数器阻塞线程
 * 多线程数据共享
 * 
 * @author shevchenko
 *
 */
public class ThreadPool {

    private static LinkedBlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<Runnable>(5);

    public static void main(String[] args) throws Exception {
        int threadCount = 12;
        MyCount myCount = new MyCount();
        CountDownLatch latch = new CountDownLatch(threadCount);
        MyRunnable myRunnable = new MyRunnable(latch, myCount);
        ThreadPoolExecutor thread =
                new ThreadPoolExecutor(5, 10, 300L, TimeUnit.SECONDS, blockingDeque, new MyRejectedExecutionHandler(latch));
        for (int i = 0; i < threadCount; i++) {
            thread.execute(myRunnable);
        }
        latch.await();
        System.out.println("有" + myCount.getCount().intValue() + "条线程被成功执行");
        System.exit(0);
    }
    
    static class MyCount {
        
        private AtomicInteger count = new AtomicInteger(0);

        public AtomicInteger getCount() {
            return count;
        }

        public void setCount(AtomicInteger count) {
            this.count = count;
        }

    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler {
        
        private CountDownLatch latch;
        
        public MyRejectedExecutionHandler(CountDownLatch latch) {
            this.latch = latch;
        }
        
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("线程池已被用完");
            latch.countDown();
        }
    }

    static class MyRunnable implements Runnable {
        
        private CountDownLatch latch;
        
        private MyCount myCount;
        
        public MyRunnable(CountDownLatch latch, MyCount myCount) {
            this.latch = latch;
            this.myCount = myCount;
        }
        
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " run");
                myCount.setCount(new AtomicInteger(myCount.getCount().addAndGet(1)));
                Thread.sleep(2000);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
