package com.example.demo.config.consumer.direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 配置一个routingKey为notify.payment的消息队列
 *
 * @author qiw-a
 */
@Configuration
public class DirectConfig {
    @Bean
    public Queue paymentNotifyQueue() {
        return new Queue("notify.payment");
    }

    @Bean
    public Queue refundNotifyQueue() {
        return new Queue("notify.refund");
    }

    @Bean
    public Queue queryOrderQueue() {
        return new Queue("query.order");
    }
}