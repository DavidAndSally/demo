package com.example.demo.config.consumer.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听routingKey为notify.payment的队列消息
 *
 * @author qiw-a
 */
@Component
@RabbitListener(queues = "notify.payment")
public class PaymentNotifyReceive2 {
    @RabbitHandler
    public void receive(String msg) {
        System.out.println("notify.payment receive message2: " + msg);
    }
}