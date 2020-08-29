package com.huayu.controller;/*
 *@author
 *@date 2020/8/2914:43
 *@Description:客户表
 */

import com.huayu.pojo.UserClien;
import com.huayu.service.imp.IUserClienServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/userClien")
public class UserClienController {
 @Autowired
 private IUserClienServiceImp iUserClienServiceImp;
 @RequestMapping("/selectuc.do")
 @ResponseBody
 public List<UserClien> selectuc(){
  List<UserClien> list=iUserClienServiceImp.list();
  return list;
 }
}
