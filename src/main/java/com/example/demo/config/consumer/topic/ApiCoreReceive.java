package com.example.demo.config.consumer.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听routingKey为api.core的队列消息
 *
 * @author qiw-a
 */
@Component
public class ApiCoreReceive {
    @RabbitHandler
    @RabbitListener(queues = "api.core")
    public void user(String msg) {
        System.out.println("api.core receive message: " + msg);
    }
}