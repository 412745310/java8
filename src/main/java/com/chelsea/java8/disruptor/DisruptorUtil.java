package com.chelsea.java8.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * disrupt工具类
 * 
 * @author shevchenko
 *
 */
public class DisruptorUtil {

    private static DisruptorUtil disruptorUtil;

    private Disruptor<MessageEvent> disruptor;

    // RingBuffer 大小，必须是 2 的 N 次方；
    private static final int RING_BUFFER_SIZE = 1024 * 1024;

    private RingBuffer<MessageEvent> ringBuffer;

    private DisruptorUtil() {
        EventThreadFactory eventThreadFactory = new EventThreadFactory();
        EventFactory<MessageEvent> eventFactory = new MessageEventFactory();
        // 在并发系统中提高性能最好的方式之一就是单一写者原则，对Disruptor也是适用的。
        // 如果在你的代码中仅仅有一个事件生产者，那么可以设置为单一生产者模式来提高系统的性能
        disruptor =
                new Disruptor<>(eventFactory, RING_BUFFER_SIZE, eventThreadFactory, ProducerType.SINGLE,
                        new YieldingWaitStrategy());
        // 广播消费（一个消息可以被所有消费者消费）
        // disruptor.handleEventsWith(new MessageEventConsumer(), new MessageEventConsumer(), new MessageEventConsumer());
        // 集群消费（一个消息只能被一个消费者消费）
        disruptor.handleEventsWithWorkerPool(new MessageEventConsumer(), new MessageEventConsumer(), new MessageEventConsumer());
    }

    /**
     * 获取 LogDisruptorUtil 实例
     *
     * @return LogDisruptorUtil
     */
    public static DisruptorUtil getInstance() {
        if (disruptorUtil == null) {
            synchronized (DisruptorUtil.class) {
                if (disruptorUtil == null) {
                    disruptorUtil = new DisruptorUtil();
                    return disruptorUtil;
                }
            }
        }
        return disruptorUtil;
    }

    /**
     * 启动disruptor
     */
    public void start() {
        disruptor.start();
        ringBuffer = disruptor.getRingBuffer();
        // 应用关闭前关闭disrupt
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                disruptor.shutdown();
            }
        }));
    }

    /**
     * 生产者发布事件
     */
    public void produce(String message) {
        // 发布事件；
        ringBuffer.publishEvent(new MessageEventTranslator(message));
        System.out.println("事件发布成功");
    }

}
