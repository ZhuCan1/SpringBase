package com.zc.hust.controller;

import com.zc.hust.pojo.IMoocJSONResult;
import com.zc.hust.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setName("zc1");
        user.setAge(221);
        user.setPassword("123456");
        user.setDesc("天朗气清1");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping("getUserJson")
    @ResponseBody
    public IMoocJSONResult getUserJson(){
        User user = new User();
        user.setName("zc2");
        user.setAge(22);
        user.setPassword("123456");
        user.setDesc("天朗气清2");
        return IMoocJSONResult.ok(user);
    }
}
