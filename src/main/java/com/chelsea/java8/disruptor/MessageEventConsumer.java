package com.chelsea.java8.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * 消费者，在此类实现具体的业务逻辑
 * 
 * @author shevchenko
 *
 */
public class MessageEventConsumer implements EventHandler<MessageEvent>, WorkHandler<MessageEvent> {
    
    @Override
    public void onEvent(MessageEvent event, long sequence, boolean endOfBatch) throws Exception {
        onEvent(event);
    }

    @Override
    public void onEvent(MessageEvent event) throws Exception {
        System.out.println("消费者消费消息：" + event.getMessage());
    }

}
