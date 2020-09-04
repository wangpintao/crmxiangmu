package com.huayu.controller;/*
 *@author
 *@date 2020/8/2914:43
 *@Description:商机表
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.JsonUtils.StulayuiJson;
import com.huayu.dateUtils.MyConvert;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.*;
import com.huayu.service.imp.*;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
public String updatecs(Commercial commercial){
 boolean b = iCommercialServiceImp.updatec(commercial);
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




 /*文件
  * */
 @RequestMapping("/files.do")
 @ResponseBody
 public StulayuiJson jsons(@RequestParam("file") MultipartFile filenames, HttpServletRequest request) throws IOException {
  StulayuiJson stulayuiJson=new StulayuiJson();
  stulayuiJson.setCode(0);
  //获得文件名
  String filenamess=filenames.getOriginalFilename();
  // 设置图片名称，不能重复，可以使用uuid
  String picName = UUID.randomUUID().toString();
  // 获取图片后缀
  String extName = filenamess.substring(filenamess.lastIndexOf("."));
  /* if(" ".equals(filenamess)){
    return "文件不存在";
   }*/
  //上传文件保存路径

  String path=request.getServletContext().getRealPath("/");
  System.out.println(path);
  File filepath=new File(path,"/upload");
/*  String filepaths= filepath.getParent();
  File files=new File(filepaths,"/upload");*/
  //判断文件夹是否存在 不存在就创建
  if(!filepath.exists()){
   filepath.mkdir();
  }
  //transferTo将文件写入磁盘，参数传入一个文件

  filenames.transferTo(new File(filepath+"/"+ picName+extName));
  String filenamesss="/"+"upload"+"/"+picName+extName;
  stulayuiJson.setMsg("上传成功");
  stulayuiJson.setData(filenamesss);
  return stulayuiJson;
 }

}
