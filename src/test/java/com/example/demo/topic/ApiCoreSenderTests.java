package com.example.demo.topic;

import com.example.demo.config.producer.topic.ApiCoreSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TopicExchange是按规则转发消息，是交换机中最灵活的一个。也是最常用的一个。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiCoreSenderTests {
    @Autowired
    private ApiCoreSender sender;
     
    @Test
    public void test_user() {
        sender.user("用户管理！");
    }
     
    @Test
    public void test_userQuery() {
        sender.userQuery("查询用户信息！");
    }
}