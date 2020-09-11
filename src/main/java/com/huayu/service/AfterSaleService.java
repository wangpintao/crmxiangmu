package com.huayu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectList;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.huayu.bo.AfterSaleBo;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.mapper.AfterSaleMapper;
import com.huayu.mapper.CommercialMapper;
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
    @Autowired
    private CommercialMapper commercialMapper;

    //售后究极查询
    @Override
    public Stulayui queryBya(Integer page, Integer limit, AfterSale afterSale,String calssType,String key,String sta) {
        Stulayui stulayui =new Stulayui();
        Page page1 = PageHelper.startPage(page,limit);
        List<AfterSale> list =new ArrayList<>();
        QueryWrapper queryWrapper =new QueryWrapper();
        System.out.println(calssType);
        System.out.println(key);
        if(!StringUtils.isEmpty(calssType)&&!StringUtils.isEmpty(key)){
            queryWrapper.like(calssType,key);
        }
        if(null!=afterSale) {
            if (!StringUtil.isEmpty(afterSale.getAftStatus())) {
                System.out.println("==" + afterSale.getAftStatus());
                if (afterSale.getAftStatus().equals("week")) {
                    list = afterSaleMapper.newWeek();
                } else if (afterSale.getAftStatus().equals("lastWeek")) {
                    list = afterSaleMapper.beforeWeek();
                } else if (afterSale.getAftStatus().equals("month")) {
                    list = afterSaleMapper.newMonth();
                } else if (afterSale.getAftStatus().equals("lastMonth")) {
                    list = afterSaleMapper.beforeMonth();
                } else if (afterSale.getAftStatus().equals("quarter")) {
                    list = afterSaleMapper.newSeason();
                } else if (afterSale.getAftStatus().equals("lastQuarter")) {
                    list = afterSaleMapper.beforeSeason();
                }  else {
                    //查询状态
                    queryWrapper.eq("aft_status", afterSale.getAftStatus());
                    list = afterSaleMapper.selectList(queryWrapper);
                }
            }else {
                System.out.println("查询所有");
                //这个else时所有值空的时候走的查询所有
                //如果queryWrapper有值就走条件查询（模糊查询）
                //如果没值就查询所有（因为queryWrapper为null查询所有）
                list=afterSaleMapper.selectList(queryWrapper);
            }
        }else{
                //如果对象null查询
                list=afterSaleMapper.selectList(queryWrapper);
            }

        stulayui.setCode(0);
        stulayui.setMsg("查询所有售后服务");
        stulayui.setCount(Integer.parseInt(String.valueOf(page1.getTotal())));
        stulayui.setData(list);
        return stulayui;
    }
    @Override
    public List<Integer> queryCount(){
        List<Integer> count =new ArrayList<>();
        for (int i =1 ;i<=3 ;i++){
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("aft_status", i+"");
            count.add(afterSaleMapper.selectList(queryWrapper).size());
        }
        count.add(afterSaleMapper.newWeek().size());
        count.add(afterSaleMapper.beforeWeek().size());
        count.add(afterSaleMapper.newMonth().size());
        count.add(afterSaleMapper.beforeMonth().size());
        count.add(afterSaleMapper.newSeason().size());
        count.add(afterSaleMapper.beforeSeason().size());
        return count;
    }

    //查询售后详情
    @Override
    public AfterSaleBo queryAllDetail(Integer aftid){
      return  afterSaleMapper.queryAllDetail(aftid);
    }

    //测试
    @Override
    public  Integer  Week() {
        return commercialMapper.ComYear();
    }
}
