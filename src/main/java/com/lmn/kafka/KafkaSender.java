package com.lmn.kafka;

import com.lmn.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaSender {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void send() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("pwd1");
        user.setAddress("恒辉");
        user.setAge(21);
        String message = JSONObject.toJSONString(user);
        kafkaTemplate.send("user", message);
    }
}
