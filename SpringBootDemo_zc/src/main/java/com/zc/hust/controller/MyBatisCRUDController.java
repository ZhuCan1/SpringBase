package com.zc.hust.controller;

import com.zc.hust.pojo.IMoocJSONResult;
import com.zc.hust.pojo.SysUser;
import com.zc.hust.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public IMoocJSONResult saveUser() throws  Exception{
        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("imooc" + new Date());
        user.setNickname("imoooc"+new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public IMoocJSONResult updateUser(){
        SysUser user = new SysUser();
        user.setId("190305G6HWC56TMW");
        user.setUsername("zc2" + new Date());
        user.setNickname("zc2"+new Date());
        user.setPassword("abc123");
        userService.updateUser(user);
        return IMoocJSONResult.ok("更新成功");
    }

    @RequestMapping("/queryUserByIdCustom")
    public IMoocJSONResult queryUserByIdCustom(String userId){
        return IMoocJSONResult.ok(userService.queryUserByIdCustom(userId));
    }

    @RequestMapping("/queryUserListPaged")
    public IMoocJSONResult queryUserListPaged(Integer page){
        //默认从第一页开始显示
        if (page == null){
            page = 1;
        }
        //每页显示5条记录
        int pageSize = 5;
         SysUser sysUser = new SysUser();
         //sysUser.setNickname("imooc");
         return IMoocJSONResult.ok(userService.queryUserListPaged(sysUser,page,pageSize));
    }




}
