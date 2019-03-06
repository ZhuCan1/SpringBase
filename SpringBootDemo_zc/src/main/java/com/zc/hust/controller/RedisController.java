package com.zc.hust.controller;

import com.zc.hust.pojo.IMoocJSONResult;
import com.zc.hust.pojo.SysUser;
import com.zc.hust.util.JsonUtils;
import com.zc.hust.util.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;
    @Autowired
    RedisOperator redis;


    //一般用法
    @RequestMapping("/test")
    public IMoocJSONResult test(){
        SysUser user = new SysUser();
        user.setId("19030");
        user.setUsername("zc2" + new Date());
        user.setNickname("zc2"+new Date());
        user.setPassword("abc123");

        strRedis.opsForValue().set("json:user",JsonUtils.objectToJson(user));
        SysUser sysUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"),SysUser.class);
        return IMoocJSONResult.ok(sysUser);
    }

    //方便的用法
    @RequestMapping("/testRedisOperator")
    public IMoocJSONResult testRedisOperator(){
        SysUser user1 = new SysUser();
        user1.setId("190301");
        user1.setUsername("zc2" + new Date());
        user1.setNickname("zc2"+new Date());
        user1.setPassword("abc123");

        SysUser user2 = new SysUser();
        user2.setId("190302");
        user2.setUsername("zc2" + new Date());
        user2.setNickname("zc2"+new Date());
        user2.setPassword("abc123");

        SysUser user3 = new SysUser();
        user3.setId("190303");
        user3.setUsername("zc2" + new Date());
        user3.setNickname("zc2"+new Date());
        user3.setPassword("abc123");

        List<SysUser> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        redis.set("json:info:userlist",JsonUtils.objectToJson(list),2000);

        List<SysUser> userList = JsonUtils.jsonToList(redis.get("json:info:userlist"),SysUser.class);
        return IMoocJSONResult.ok(userList);
    }
}
