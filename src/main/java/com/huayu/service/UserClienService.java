package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.UserClienMapper;
import com.huayu.mapper.UserMapper;
import com.huayu.pojo.User;
import com.huayu.pojo.UserClien;
import com.huayu.service.imp.IUserClienServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserClienService extends ServiceImpl<UserClienMapper,UserClien> implements IUserClienServiceImp {
 @Autowired
 private UserClienMapper userClienMapper;

 public UserClien selectId(Integer ucid){
  return userClienMapper.selectId(ucid);
 }
//
 @Override
 public List<UserClien> listUser() {
  return userClienMapper.listUser();
 }

 ;

}
