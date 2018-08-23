package com.example.service;

import com.github.pagehelper.PageInfo;

public interface TestService1 {

    PageInfo<User> findAllUser(int pageNum,int pageSize);

}
