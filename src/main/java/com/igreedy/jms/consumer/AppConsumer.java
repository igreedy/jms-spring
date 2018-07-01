package com.igreedy.jms.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by igreedy on 2018/7/1
 */
public class AppConsumer {
    public static void main(String[] args) {
        // 由于接收消息是异步过程，如果context.close();的话，消息可能接收不全。
        ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
