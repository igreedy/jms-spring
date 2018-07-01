package com.igreedy.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;


/**
 * Created by igreedy on 2018/7/1
 */
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;

    // 目的地可能有多个，所以用资源的name来区分
    @Resource(name = "queueDestination")
    Destination destination;

    public void sendMessage(final String message) {
        // 使用JmsTemplate发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            // 创建消息
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
        System.out.println("发送消息：" + message);
    }
}
