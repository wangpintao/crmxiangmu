package com.huayu.controller;/*
 *@author
 *@date 2020/8/2914:43
 *@Description:商机表
 */

import com.huayu.dateUtils.MyConvert;
import com.huayu.pojo.*;
import com.huayu.service.imp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/commercial")
public class CommercialController {
 @Autowired
 private IUserClienServiceImp iUserClienServiceImp;

 @Autowired
 private ICommercialServiceImp iCommercialServiceImp;

 /*根据id查询客户信息
  * */
 @RequestMapping("/selectid.do")
 @ResponseBody
 public UserClien selectid(Integer ucid){
  UserClien u=iUserClienServiceImp.selectId(ucid);
  return u;
 }

 /*添加商机
  * */
 @RequestMapping("/addCommercial.do")
 public void addCommercial(Commercial commercial){
  iCommercialServiceImp.save(commercial);

 }



}
