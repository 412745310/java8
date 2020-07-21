package com.chelsea.java8.disruptor;

/**
 * 测试类
 * 
 * @author shevchenko
 *
 */
public class Main {
    
    public static void main(String[] args) {
        //获取实例
        DisruptorUtil disruptorUtil = DisruptorUtil.getInstance();
        //启动
        disruptorUtil.start();
        //发布消息
        disruptorUtil.produce("disruptor test !");
    }

}
