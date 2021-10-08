package com.mlming.springboot.dao;

import com.mlming.springboot.SapmallApplication;
import com.mlming.springboot.SapmallApplicationTests;
import com.mlming.springboot.pojo.Category;
import com.mlming.springboot.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserMapperTest: UserMapper的测试类
 */
public class UserMapperTest extends SapmallApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}