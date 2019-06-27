package com.example.demo.config.producer.direct;

import com.example.demo.domain.Order;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryOrderSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
     
    public void sender(String orderId){
        System.out.println("query.order send message: "+orderId);
        Order order = (Order) rabbitTemplate.convertSendAndReceive("query.order", orderId);
        System.out.println("query.order return message: "+ order);
    }
}