package com.lmn.user.service;

import com.lmn.user.domain.User;

import java.util.List;

public interface UserService {

    int insertUser(User user);

    List<User> listAll();
}