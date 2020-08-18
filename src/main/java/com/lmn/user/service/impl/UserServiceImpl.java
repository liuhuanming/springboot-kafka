package com.lmn.user.service.impl;

import com.lmn.user.dao.UserMapper;
import com.lmn.user.domain.User;
import com.lmn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> listAll() {
        return userMapper.selectAll();
    }
}
