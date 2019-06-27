package com.example.demo.config.producer.direct;

import com.example.demo.domain.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 添加一个消息发送类（生产者）
 *
 * @author qiw-a
 */
@Component
public class RefundNotifySender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender(Order order) {
        System.out.println("notify.refund send message: " + order.toString());
        rabbitTemplate.convertAndSend("notify.refund", order);
    }
}