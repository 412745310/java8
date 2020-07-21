package com.chelsea.java8.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * 事件工厂，disruptor生产消息对象
 * 
 * @author shevchenko
 *
 */
public class MessageEventFactory implements EventFactory<MessageEvent> {
    
    @Override
    public MessageEvent newInstance() {
        return new MessageEvent();
    }

}
