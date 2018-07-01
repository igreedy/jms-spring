package com.igreedy.jms.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by igreedy on 2018/7/1
 */
public class AppProducer {
    public static void main(String[] args) {
        // 引入 resources/producer.xml 配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");

        ProducerService service = context.getBean(ProducerService.class);
        for (int i = 0; i < 100; i++) {
            service.sendMessage("test" + i);
        }
    }
}
