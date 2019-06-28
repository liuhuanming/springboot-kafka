package com.lmn.user.service;

import java.util.List;

import com.lmn.user.domain.User;

public interface UserService {
	int insertUser(User user);
	List<User> listAll();
}