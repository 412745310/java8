package com.chelsea.java8.disruptor;

import com.lmax.disruptor.EventTranslator;

public class MessageEventTranslator implements EventTranslator<MessageEvent> {
    
    private String message;
    
    public MessageEventTranslator(String message) {
        this.message = message;
    }
    
    @Override
    public void translateTo(MessageEvent messageEvent, long l) {
        messageEvent.setMessage(message);
    }

}
