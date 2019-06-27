package com.example.demo.config.producer.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 添加一个user()方法，发送消息至coreExchange交换机且routingKey为api.core.user
 * 添加一个userQuery()方法，发送消息至coreExchange交换机且routingKey为api.core.user.query
 *
 * @author qiw-a
 */
@Component
public class ApiCoreSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void user(String msg) {
        System.out.println("api.core.user send message: " + msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user", msg);
    }

    public void userQuery(String msg) {
        System.out.println("api.core.user send message: " + msg);
        rabbitTemplate.convertAndSend("coreExchange", "api.core.user.query", msg);
    }
}