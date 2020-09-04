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
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
        stulayui.setCode(0);
        stulayui.setMsg("查询所有售后服务");
        stulayui.setCount(Integer.parseInt(String.valueOf(page1.getTotal())));
        stulayui.setData(list);
        return stulayui;
    }
    @Override
    public Stulayui queryBya(Integer page, Integer limit, AfterSale afterSale,String calssType,String key,String value) {
        Stulayui stulayui =new Stulayui();
        Page page1 = PageHelper.startPage(page,limit,true);
        List<AfterSale> list = new ArrayList<>();
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.like(calssType,key);
        if (!StringUtils.isEmpty(calssType)&&!StringUtils.isEmpty(key)){
            queryWrapper.like(calssType,key);
            //模糊查询
            list = afterSaleMapper.selectList(queryWrapper);
        } if (value!=null&&value.equals("newWeek")){
            list = afterSaleMapper.newWeek();
        }
        else {
            //查询所有
            list = afterSaleMapper.queryMany(page1,afterSale);
        }
        stulayui.setCode(0);
        stulayui.setMsg("查询所有售后服务");
        stulayui.setCount(Integer.parseInt(String.valueOf(page1.getTotal())));
        stulayui.setData(list);
        return stulayui;
    }

    //周
    @Override
    public Stulayui newWeek(Integer page, Integer limit) {
        Stulayui stulayui =new Stulayui();
        Page page1 = PageHelper.startPage(page,limit,true);
        List<AfterSale> list = afterSaleMapper.newWeek();
        stulayui.setCode(0);
        stulayui.setMsg("查询所有售后服务");
        stulayui.setCount(Integer.parseInt(String.valueOf(page1.getTotal())));
        stulayui.setData(list);
        return stulayui;
    }

    //月
    @Override
    public List<AfterSale> newMonth() {
        return afterSaleMapper.newMonth();
    }

    //季
    @Override
    public List<AfterSale> newSeason() {
        return afterSaleMapper.newSeason();
    }

    //查询售后详情
    @Override
    public AfterSaleBo queryAllDetail(Integer aftid){
      return  afterSaleMapper.queryAllDetail(aftid);
    }
}
