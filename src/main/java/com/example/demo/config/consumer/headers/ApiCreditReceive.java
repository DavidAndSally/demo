package com.example.demo.config.consumer.headers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 添加creditBank()方法，监听routingKey为credit.bank的队列消息
 * 添加creditFinance()方法，监听routingKey为credit.finance的队列消息
 *
 * @author qiw-a
 */
@Component
public class ApiCreditReceive {
    @RabbitHandler
    @RabbitListener(queues = "credit.bank")
    public void creditBank(String msg) {
        System.out.println("credit.bank receive message: " + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "credit.finance")
    public void creditFinance(String msg) {
        System.out.println("credit.finance receive message: " + msg);
    }
}