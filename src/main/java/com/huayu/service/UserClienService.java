package com.huayu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.bo.ClientBo;
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

 /*客户联和
 * */
 @Override
 public List<ClientBo> queryMany(IPage<UserClien> page1) {
   ClientBo clientBo=new ClientBo();
   QueryWrapper wrapper=new QueryWrapper();
   IPage<UserClien>  list=userClienMapper.selectPage(page1,null);
   List<UserClien> clienList= list.getRecords();
   for(UserClien cli:clienList){
    Integer ucid= cli.getUcid();
    wrapper.eq("ucid",ucid);
    UserClien userClien=userClienMapper.selectOne(wrapper);
    userClien.getCliName();

   }


  return null;
 }

 @Override
 public UserClien queryByid(Integer ucid) {
  return userClienMapper.queryByid(ucid);
 }

 @Override
 public boolean updatecl(UserClien userClien) {
  return userClienMapper.updatecl(userClien) ;
 }
}
