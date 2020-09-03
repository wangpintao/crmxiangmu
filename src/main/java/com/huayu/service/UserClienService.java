package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.mapper.UserClienMapper;
import com.huayu.mapper.UserMapper;
import com.huayu.pojo.AfterSale;
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

 @Override
 public List<UserClien> listUser() {
  return userClienMapper.listUser();
 }

 @Override
 public Stulayui queryMany(Integer page,Integer limit, Integer clientid, String keys) {
  Stulayui stulayui =new Stulayui();
  Page page1 = PageHelper.startPage(page,limit,true);
  List<UserClien> list = userClienMapper.queryMany(page1,clientid, keys);
  System.out.println(list);
  System.out.println(list);
  stulayui.setCode(0);
  stulayui.setMsg("查询客户信息");
  stulayui.setCount(Integer.parseInt(String.valueOf(page1.getTotal())));
  stulayui.setData(list);
  return stulayui;
 }

 @Override
 public UserClien queryByid(Integer ucid) {
  return userClienMapper.queryByid(ucid);
 }


}
