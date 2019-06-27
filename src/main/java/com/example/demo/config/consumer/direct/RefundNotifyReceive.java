package com.example.demo.config.consumer.direct;

import com.example.demo.domain.Order;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听routingKey为notify.refund的队列消息
 *
 * @author qiw-a
 */
@Component
@RabbitListener(queues = "notify.refund")
public class RefundNotifyReceive {
    @RabbitHandler
    public void receive(Order order) {
        System.out.println("notify.refund receive message: " + order.toString());
    }
}