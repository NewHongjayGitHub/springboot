package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.service.TestService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/testController1")
public class TestController1 {

    @Autowired
    TestService1 testService1;

    @ResponseBody
    @RequestMapping(value = "getAllUser",method = RequestMethod.POST)
    public JSONObject getAllUser(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1")
            int pageNum,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10")
            int pageSize){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("users",testService1.findAllUser(pageNum,pageSize));
        return jsonObject;
    }

}
