package com.example.demo.direct;

import com.example.demo.config.producer.direct.RefundNotifySender;
import com.example.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 请求信息可能包含多个字段。为了保证生产者与消费者两端的字段一致性，通常会传递一个对象。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RefundNotifySenderTests {
    @Autowired
    private RefundNotifySender sender;

    @Test
    public void test_sender() {
        Order order = new Order();
        order.setId(100001);
        order.setOrderId(String.valueOf(System.currentTimeMillis()));
        order.setAmount(new BigDecimal("1999.99"));
        order.setCreateTime(new Date());
        sender.sender(order);
    }
}