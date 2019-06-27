package com.example.demo.direct;

import com.example.demo.config.producer.direct.QueryOrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryOrderSenderTests {
    @Autowired
    private QueryOrderSender sender;

    @Test
    public void test_sender() {
        sender.sender("900000001");
    }
}