package com.example.demo.config.producer.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 添加一个generateReports()方法，发送消息至reportExchange交换机
 *
 * @author qiw-a
 */
@Component
public class ApiReportSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void generateReports(String msg) {
        System.out.println("api.generate.reports send message: " + msg);
        rabbitTemplate.convertAndSend("reportExchange", "api.generate.reports", msg);
    }
}