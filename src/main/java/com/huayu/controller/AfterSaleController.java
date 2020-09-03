package com.huayu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.bo.AfterSaleBo;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.AfterSale;
import com.huayu.pojo.Contract;
import com.huayu.pojo.UserClien;
import com.huayu.service.imp.IAfterSaleServiceImp;
import com.huayu.service.imp.IContractServiceImp;
import com.huayu.service.imp.IUserClienServiceImp;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
* 售后服务
* */

@Controller
@RequestMapping("/after/")
public class AfterSaleController {

    @Autowired
    private IAfterSaleServiceImp iAfterSaleServiceImp;
    @Autowired
    private IUserClienServiceImp iUserClienServiceImp;
    @Autowired
    private IContractServiceImp iContractServiceImp;

    /*
    * 查询所有服务
    * */
    @GetMapping("/queryAll.do")
    @ResponseBody
    public Stulayui queryAll(Integer page,Integer limit,AfterSale afterSale){
       return iAfterSaleServiceImp.queryMany(page,limit,afterSale);
    }

    @PostMapping("/add.do")
    public String add(AfterSale afterSale){
        iAfterSaleServiceImp.save(afterSale);
        return "redirect:/sale/saledisplay.html";
    }
    //添加时查询客户
    @GetMapping("/queryClien.do")
    @ResponseBody
    public List<UserClien> queryClien(){
        return iUserClienServiceImp.list();
    }

    //添加时查询客户下的合同
    @GetMapping("/queryByCon.do")
    @ResponseBody
    public List<Contract> queryByCon(Integer conUcid){
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("con_ucid",conUcid);
        List<Contract> list = iContractServiceImp.list(queryWrapper);
        System.out.println(list);
        return list;
    }

    @GetMapping("/queryBya.do")
    @ResponseBody
    public Stulayui queryBya(Integer page, Integer limit, AfterSale afterSale,String column,String value){
        System.out.println("字段名"+column);
        System.out.println("文本值"+value);
        return iAfterSaleServiceImp.queryBya(page, limit, afterSale, column, value);
    }

    //去修改
    @GetMapping("/toupdate.do")
    public ModelAndView toupdate(Integer aftid){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("aftlist",iAfterSaleServiceImp.queryAllDetail(aftid));
        modelAndView.setViewName("/sale/detsaledisplay.html");
       return modelAndView;
    }


}
