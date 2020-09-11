package com.huayu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.huayu.bo.CommercialBo;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.mapper.CommercialMapper;
import com.huayu.mapper.ContractMapper;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Contract;
import com.huayu.service.imp.ICommercialServiceImp;
import com.huayu.service.imp.IContractServiceImp;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommercialService extends ServiceImpl<CommercialMapper, Commercial> implements ICommercialServiceImp {
@Autowired
 private CommercialMapper commercialMapper;

/*商机联合
* */
 @Override
 public boolean updatec(Commercial commercial) {
  return commercialMapper.updatec(commercial);
 }

 public Stulayui queryCom(Integer page, Integer limit,Commercial commercial ){
  Stulayui stulayui=new Stulayui();
  List<CommercialBo> list=new ArrayList<>();
  QueryWrapper queryWrapper =new QueryWrapper();
  Page page1 = PageHelper.startPage(page,limit);
  //List<CommercialBo>  commercialBoList=new ArrayList<>();
  if(null!=commercial){
   //判断字段与主页点击事件匹配
   /*if (!StringUtil.isEmpty(commercial.getComBusname())) {

    System.out.println("==" + commercial.getComBusname());
    if (commercial.getComBusname().equals("week")) {//时间匹配

    } else if (commercial.getComBusname().equals("lastWeek")) {

    } else if (commercial.getComBusname().equals("month")) {

    } else if (commercial.getComBusname().equals("lastMonth")) {

    } else if (commercial.getComBusname().equals("quarter")) {

    } else if (commercial.getComBusname().equals("lastQuarter")) {

    }  else   if(commercial.getComBusname().equals("fz")) {//我的商机

    }  else if (commercial.getComBusname().equals("cy")) {

    }else if (commercial.getComBusname().equals("gz")) {

    }else if (commercial.getComBusname().equals("seven")) {//未跟单时间

    }else if (commercial.getComBusname().equals("thirty")) {

    }else if (commercial.getComBusname().equals("ninety")) {

    } else{//查询商机状态
     queryWrapper.eq("com_staid",commercial.getComBusname());
     list= commercialMapper.selectList(queryWrapper);
    }
   }else {
    System.out.println("查询所有");
    //这个else时所有值空的时候走的查询所有
    //如果queryWrapper有值就走条件查询（模糊查询）
    //如果没值就查询所有（因为queryWrapper为null查询所有）
    list= commercialMapper.queryComm(page1, commercial);
   }*/
  }else {  //如果对象null查询
   list= commercialMapper.queryComm(page1, commercial);
  }
  list= commercialMapper.queryComm(page1, commercial);
  stulayui.setCode(0);
  stulayui.setMsg("查询成功");
  stulayui.setCount(Integer.valueOf(String.valueOf(page1.getTotal())));
  stulayui.setData(list);
  return stulayui;
 }


}
