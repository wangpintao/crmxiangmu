package com.huayu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.bo.AfterSaleBo;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.mapper.AfterSaleMapper;
import com.huayu.pojo.AfterSale;
import com.huayu.service.imp.IAfterSaleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AfterSaleService extends ServiceImpl<AfterSaleMapper, AfterSale> implements IAfterSaleServiceImp {

    @Autowired
    private AfterSaleMapper afterSaleMapper;

    @Override
    public Stulayui queryMany(Integer page, Integer limit, AfterSale afterSale) {
        Stulayui stulayui =new Stulayui();
        Page page1 = PageHelper.startPage(page,limit,true);
        List<AfterSale> list = afterSaleMapper.queryMany(page1,afterSale);
        System.out.println(list);
        System.out.println(list);
        stulayui.setCode(0);
        stulayui.setMsg("查询所有售后服务");
        stulayui.setCount(Integer.parseInt(String.valueOf(page1.getTotal())));
        stulayui.setData(list);
        return stulayui;
    }
    @Override
    public Stulayui queryBya(Integer page, Integer limit, AfterSale afterSale,String column,String value) {
        Stulayui stulayui =new Stulayui();
        Page page1 = PageHelper.startPage(page,limit,true);
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.like(column,value);
        List<AfterSale> list = afterSaleMapper.selectList(queryWrapper);
        System.out.println(list);
        System.out.println(list);
        stulayui.setCode(0);
        stulayui.setMsg("查询所有售后服务");
        stulayui.setCount(Integer.parseInt(String.valueOf(page1.getTotal())));
        stulayui.setData(list);
        return stulayui;
    }

    @Override
    public AfterSaleBo queryAllDetail(Integer aftid){
      return  afterSaleMapper.queryAllDetail(aftid);
    }
}
