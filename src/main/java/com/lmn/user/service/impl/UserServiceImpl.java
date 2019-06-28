package com.lmn.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmn.user.dao.UserMapper;
import com.lmn.user.domain.User;
import com.lmn.user.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}

	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return userMapper.selectAll();
	}

}
