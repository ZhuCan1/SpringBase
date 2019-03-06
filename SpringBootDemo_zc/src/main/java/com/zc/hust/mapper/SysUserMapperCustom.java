package com.zc.hust.mapper;

import com.zc.hust.pojo.SysUser;

import java.util.List;

///自定义mapper
public interface SysUserMapperCustom {
    List<SysUser> queryUserSimplyInfoById(String id);
}
