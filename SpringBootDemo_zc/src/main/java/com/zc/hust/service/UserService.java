package com.zc.hust.service;

import com.zc.hust.pojo.SysUser;

import java.util.List;

public interface UserService {
    public void saveUser(SysUser user)throws  Exception;
    public void updateUser(SysUser user);
    public void deleteUser(String userId);
    public SysUser queryUser(String userId);
    public List<SysUser> queryUserList(SysUser user);
    public SysUser queryUserByIdCustom(String userId);
    public void saveUserTransactional(SysUser user);
    public List<SysUser>queryUserListPaged(SysUser user,int page,int pageSize);

}
