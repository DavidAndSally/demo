package com.example.demo.config.producer.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 将消息发送至默认的交换机且routingKey为notify.payment
 *
 * @author qiw-a
 */
@Component
public class PaymentNotifySender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender(String msg) {
        System.out.println("notify.payment send message: " + msg);
        rabbitTemplate.convertAndSend("notify.payment", msg);
    }
}