package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.UserMapper;
import com.huayu.pojo.User;
import com.huayu.service.imp.IUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends ServiceImpl<UserMapper, User> implements IUserServiceImp {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer queryNameByID(String username) {
        return userMapper.queryNameByID(username);
    }
}
