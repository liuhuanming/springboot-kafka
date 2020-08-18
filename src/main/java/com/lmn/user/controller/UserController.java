package com.lmn.user.controller;

import com.lmn.common.result.Response;
import com.lmn.common.result.Result;
import com.lmn.user.domain.User;
import com.lmn.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "用户", tags = {"用户接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "增加用户")
    @PutMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public Result insert(User user) {
        int n = userService.insertUser(user);
        return Response.ok();
    }

    @ApiOperation(value = "查询用户")
    @GetMapping(value = "/getAll", produces = {"application/json;charset=UTF-8"})
    public Result<List<User>> selectAll() {
        List<User> userList = userService.listAll();
        return Response.ok(userList);
    }
}
