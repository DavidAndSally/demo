package com.example.demo.direct;

import com.example.demo.config.producer.direct.PaymentNotifySender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DirectExchange是RabbitMQ的默认交换机，直接使用routingKey匹配队列。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentNotifySenderTests {
    @Autowired
    private PaymentNotifySender sender;

    @Test
    public void test_sender() {
        sender.sender("支付订单号：" + System.currentTimeMillis());
    }

    /**
     * 多对一
     * @throws Exception
     */
    @Test
    public void test_sender_many2one_1() throws Exception {
        for (int i = 0; i < 20; i+=2) {
            sender.sender("支付订单号："+i);
            Thread.sleep(1000);
        }
    }

    /**
     * 多对一
     * @throws Exception
     */
    @Test
    public void test_sender_many2one_2() throws Exception {
        for (int i = 1; i < 20; i+=2) {
            sender.sender("支付订单号："+i);
            Thread.sleep(1000);
        }
    }

    /**
     * 一对多
     */
    @Test
    public void test_sender_one2many() {
        for (int i = 0; i < 20; i++) {
            sender.sender("支付订单号："+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}