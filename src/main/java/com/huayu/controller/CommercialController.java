package com.huayu.controller;/*
 *@author
 *@date 2020/8/2914:43
 *@Description:商机表
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.dateUtils.MyConvert;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.*;
import com.huayu.service.imp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 public String addCommercial(Commercial commercial){
  iCommercialServiceImp.save(commercial);
  return "redirect:/market/selectmarket.html";
 }

/*修改之前
* */
@RequestMapping("/toc.do")
public String toc(Integer coid,Integer ucid, Model model){
 System.out.println(coid+"|||"+ucid);
 model.addAttribute("client",iUserClienServiceImp.queryByid(ucid));
 QueryWrapper wrapper=new QueryWrapper();
 wrapper.eq("coid",coid);
 Commercial commercial= iCommercialServiceImp.getOne(wrapper);
 model.addAttribute("commercial",commercial);
 return "/market/updatemarket.html";
}

/*修改商机
* */
@RequestMapping("/updatec.do")
public String updatec(Commercial commercial){
 iCommercialServiceImp.saveOrUpdate(commercial);
 return "redirect:/market/selectmarket.html";
}

/*
* 查询商机
* */
 @RequestMapping("/commercial.do")
 @ResponseBody
 public Stulayui clients(){
  Stulayui stulayui=new Stulayui();
  List<Commercial> list= iCommercialServiceImp.list();
  stulayui.setCode(0);
  stulayui.setMsg("查询成功");
  stulayui.setCount(list.size());
  stulayui.setData(list);
  return stulayui;
 }


}
