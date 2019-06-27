package com.example.demo.config.producer.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 添加一个order()方法，发送消息至paymentExchange交换机且routingKey为api.payment.order
 * 添加一个orderQuery()方法，发送消息至paymentExchange交换机且routingKey为api.payment.order.query
 * 添加一个orderDetailQuery()方法，发送消息至paymentExchange交换机且routingKey为api.payment.order.detail.query
 *
 * @author qiw-a
 */
@Component
public class ApiPaymentSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void order(String msg) {
        System.out.println("api.payment.order send message: " + msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order", msg);
    }

    public void orderQuery(String msg) {
        System.out.println("api.payment.order.query send message: " + msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order.query", msg);
    }

    public void orderDetailQuery(String msg) {
        System.out.println("api.payment.order.detail.query send message: " + msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order.detail.query", msg);
    }
}