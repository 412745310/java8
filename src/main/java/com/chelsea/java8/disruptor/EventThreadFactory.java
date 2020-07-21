package com.chelsea.java8.disruptor;

import java.util.concurrent.ThreadFactory;

/**
 * 线程工厂，用于生产消费者线程
 * 
 * @author shevchenko
 *
 */
public class EventThreadFactory implements ThreadFactory {
    
    @Override
    public Thread newThread(Runnable r) {
      return new Thread(r);
    }

}
