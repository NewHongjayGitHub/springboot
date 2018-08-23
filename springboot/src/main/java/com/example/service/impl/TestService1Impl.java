package com.example.service.impl;

import com.example.service.TestService1;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService1Impl implements TestService1 {
    @Autowired
    UserMapper userMapper;

    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIsDeletedEqualTo(0);
        List<User> users = userMapper.selectByExample(userExample);

        PageInfo<User> result = new PageInfo<>(users);
        return result;
    }
}
