package com.huayu.controller;/*
 *@author
 *@date 2020/8/2914:43
 *@Description:客户表
 */

import com.huayu.pojo.CliBusiness;
import com.huayu.pojo.CliKind;
import com.huayu.pojo.CliSource;
import com.huayu.pojo.UserClien;
import com.huayu.service.imp.ICliBusinessServiceImp;
import com.huayu.service.imp.ICliKindServiceImp;
import com.huayu.service.imp.ICliSourceServiceImp;
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

 @Autowired
 private ICliBusinessServiceImp iCliBusinessServiceImp;

 @Autowired
 private ICliKindServiceImp iCliKindServiceImp;

 @Autowired
 private ICliSourceServiceImp iCliSourceServiceImp;

/*查询分类表
* */
@RequestMapping("/selectKind.do")
@ResponseBody
public List<CliKind> selectKind(){
 return iCliKindServiceImp.list();
}

 /*查询客户所属行业表
  * */
 @RequestMapping("/selectBusiness.do")
 @ResponseBody
 public List<CliBusiness> selectBusiness(){
  return iCliBusinessServiceImp.list();
 }

 /*查询客户来源表
  * */
 @RequestMapping("/selectSource.do")
 @ResponseBody
 public List<CliSource> selectSource(){
  return iCliSourceServiceImp.list();
 }

 /*添加客户
 * */
 @RequestMapping("/addClient.do")
 public void addClient(UserClien userClien ){
   iUserClienServiceImp.save(userClien);
 }


/*查询客户表
* */
 @RequestMapping("/selectuc.do")
 @ResponseBody
 public List<UserClien> selectuc(){
  List<UserClien> list=iUserClienServiceImp.listUser();
  return list;
 }

 /*根据id查询客户信息
  * */
 @RequestMapping("/selectid.do")
 @ResponseBody
 public UserClien selectid(Integer ucid){
  return iUserClienServiceImp.getById(ucid);
 }





}
