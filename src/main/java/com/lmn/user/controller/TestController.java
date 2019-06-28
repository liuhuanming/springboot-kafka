package com.lmn.user.controller;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmn.common.result.Response;
import com.lmn.common.result.Result;
import com.lmn.user.domain.User;
import com.lmn.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
@Api(value="测试",tags={"测试接口"})
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {
	@Autowired
	private UserService userService;
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@ApiOperation(value="增加用户")
	@PutMapping(value = "/add", produces = { "application/json;charset=UTF-8" })
	public Result insert(User user){
		int n = userService.insertUser(user);
		return Response.ok();
	}
	
	@ApiOperation(value="查询用户")
	@GetMapping(value = "/getAll", produces = { "application/json;charset=UTF-8" })
	public Result<List<User>> selectAll(){
		List<User> userList = userService.listAll();
		return Response.ok(userList);
	}
	
	@ApiOperation(value="测试kafka")
    @GetMapping("/kafka")
    public Result testKafka() {
        int iMax = 100;
        for (int i = 1; i < iMax; i++) {
            kafkaTemplate.send("test","key" + i, "data" + i);
        }
       return Response.ok();
    }

    @KafkaListener(topics = "test")
    public void receive(ConsumerRecord<?, ?> consumer) {
        log.info("{} - {}:{}", consumer.topic(), consumer.key(), consumer.value());
    }
    
 }
