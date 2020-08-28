package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.UserClienMapper;
import com.huayu.mapper.UserMapper;
import com.huayu.pojo.User;
import com.huayu.pojo.UserClien;
import com.huayu.service.imp.IUserClienServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserClienService extends ServiceImpl<UserClienMapper,UserClien> implements IUserClienServiceImp {

}
