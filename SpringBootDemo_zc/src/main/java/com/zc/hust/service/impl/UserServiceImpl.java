package com.zc.hust.service.impl;

import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.StringUtils;
import com.zc.hust.mapper.SysUserMapper;
import com.zc.hust.mapper.SysUserMapperCustom;
import com.zc.hust.pojo.SysUser;
import com.zc.hust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserMapperCustom userMapperCustom;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(SysUser user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(SysUser user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(String userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser queryUser(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SysUser> queryUserList(SysUser user) {
        return userMapper.select(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser queryUserByIdCustom(String userId) {
        List<SysUser> list = userMapperCustom.queryUserSimplyInfoById(userId);
        if (list != null && !list.isEmpty()) {
            return  list.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUserTransactional(SysUser user) {
        userMapper.insert(user);
        int a = 1 / 0;
        user.setIsDelete(1);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<SysUser> queryUserListPaged(SysUser user, int page, int pageSize) {
       //设置分页开始位置和每页显示的条数
        PageHelper.startPage(page,pageSize);
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespaceOnly(user.getNickname())){
            criteria.andLike("nickname","%" + user.getNickname() + "%");
        }
        example.orderBy("registTime").desc();
        List<SysUser> list = userMapper.selectByExample(example);
        return list;
    }
}
