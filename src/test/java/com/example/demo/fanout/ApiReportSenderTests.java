package com.example.demo.fanout;

import com.example.demo.config.producer.fanout.ApiReportSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FanoutExchange交换机是转发消息到所有绑定队列（广播模式，和routingKey没有关系）。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiReportSenderTests {
    @Autowired
    private ApiReportSender sender;

    @Test
    public void test_generateReports() {
        sender.generateReports("开始生成报表！");
    }
}