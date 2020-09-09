package com.huayu.controller;/*
 *@author
 *@date 2020/8/2914:43
 *@Description:客户表
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huayu.bo.ClientBo;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.*;
import com.huayu.service.imp.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

 @Autowired
 private ICommercialServiceImp iCommercialServiceImp;

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
 public String addClient(UserClien userClien ){
   iUserClienServiceImp.save(userClien);
   return "redirect:/client/clientselect.html";
 }


/*查询客户表
* */
 @RequestMapping("/selectuc.do")
 @ResponseBody
 public List<UserClien> selectuc(){
  List<UserClien> list=iUserClienServiceImp.listUser();
  return list;
 }

 /*根据id修改
 * */
 @RequestMapping("/selectucs.do")
 @ResponseBody
 public UserClien selectucs(Integer ucid){
 return iUserClienServiceImp.queryByid(ucid);
 }

 @GetMapping ("/toupdate.do")
 public ModelAndView toupdate(Integer ucid){
  ModelAndView view=new ModelAndView();
  view.addObject("client",iUserClienServiceImp.queryByid(ucid));
  view.addObject("business",iCliBusinessServiceImp.list());
  view.addObject("kind",iCliKindServiceImp.list());
  view.addObject("source",iCliSourceServiceImp.list());
  view.setViewName("/client/updateclient.html");
  return view;
 }
 /*修改
 * */
@PostMapping("/update.do")
 public String update(UserClien userClien){
 System.out.println(userClien);
  iUserClienServiceImp.updatecl(userClien);
  return "redirect:/client/clientselect.html";
 }

 /*商机联合 , Integer clientid, String keys
  * */
 @RequestMapping("/clientid.do")
 @ResponseBody
 public Stulayui clientid(Integer page, Integer limit, String clientid ,String keys){
  System.out.println(clientid+"||"+keys);
  return iUserClienServiceImp.queryMany(page,limit,clientid,keys);
 }

 @RequestMapping("/clients.do")
 @ResponseBody
 public Stulayui clients(){
  Stulayui stulayui=new Stulayui();
  List<UserClien> list= iUserClienServiceImp.list();
  stulayui.setCode(0);
  stulayui.setMsg("查询成功");
  stulayui.setCount(list.size());
  stulayui.setData(list);
  return stulayui;
 }
/*删除之前
* */
@RequestMapping("/todels.do")
@ResponseBody
public List<Commercial>   todeletes(Integer ucid){
 QueryWrapper wrapper=new QueryWrapper();
 wrapper.eq("com_ucid",ucid);
 List<Commercial> list=iCommercialServiceImp.list(wrapper);
 return list;
}


 /*删除客户
 * */
 @RequestMapping("/dels.do")
 @ResponseBody
 public boolean deletes(Integer ucid){
  QueryWrapper wrapper=new QueryWrapper();
  wrapper.eq("ucid",ucid);
 boolean b= iUserClienServiceImp.remove(wrapper);
 System.out.println(b);
 return b;
 }



}
