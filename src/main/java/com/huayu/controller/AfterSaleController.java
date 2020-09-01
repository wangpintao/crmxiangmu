package com.huayu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.AfterSale;
import com.huayu.service.imp.IAfterSaleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
* 售后服务
* */

@Controller
@RequestMapping("/after/")
public class AfterSaleController {

    @Autowired
    private IAfterSaleServiceImp iAfterSaleServiceImp;

    /*
    * 查询所有服务
    * */
    @GetMapping("/queryAll.do")
    @ResponseBody
    public Stulayui queryAll(Integer page,Integer limit){
        Stulayui stulayui =new Stulayui();
     /*   Page page1 =new Page(page,limit);
        System.out.println("分页"+page1);
        IPage<AfterSale> iPage = iAfterSaleServiceImp.page(page1);
        System.out.println("结果集"+iPage);*/
        List<AfterSale> afterSaleList = iAfterSaleServiceImp.list();
        System.out.println(afterSaleList);
        stulayui.setCode(0);
        stulayui.setMsg("查询所有售后服务");
        stulayui.setCount(afterSaleList.size());
        stulayui.setData(afterSaleList);
        return stulayui;
    }
    @GetMapping("/querytext.do")
    @ResponseBody
    public List<AfterSale> querytext(){
        List<AfterSale> afterSaleList = iAfterSaleServiceImp.list();
        return afterSaleList;
    }
}
