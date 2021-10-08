package com.mlming.springboot.pojo;

import lombok.Data;
import lombok.Generated;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;

    private Date createTime;

    private Date updateTime;
}