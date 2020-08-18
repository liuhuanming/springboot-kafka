package com.lmn.user.domain;

import lombok.Data;

import javax.persistence.*;

@Table(name = "b_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 等级
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;
}