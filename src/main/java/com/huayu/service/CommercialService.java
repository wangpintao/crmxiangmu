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
  Page page1 = PageHelper.startPage(page,limit);
  //List<CommercialBo>  commercialBoList=new ArrayList<>();
  List<CommercialBo> com= commercialMapper.queryComm(page1, commercial);
  stulayui.setCode(0);
  stulayui.setMsg("查询成功");
  stulayui.setCount(Integer.valueOf(String.valueOf(page1.getTotal())));
  stulayui.setData(com);
  return stulayui;
 }
}
