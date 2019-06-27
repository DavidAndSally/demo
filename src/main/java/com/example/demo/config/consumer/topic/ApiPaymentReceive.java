package com.example.demo.config.consumer.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听routingKey为api.payment的队列消息
 *
 * @author qiw-a
 */
@Component
public class ApiPaymentReceive {
    @RabbitHandler
    @RabbitListener(queues = "api.payment")
    public void order(String msg) {
        System.out.println("api.payment.order receive message: " + msg);
    }
}