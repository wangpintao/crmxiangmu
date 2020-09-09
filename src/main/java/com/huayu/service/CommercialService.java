package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.bo.CommercialBo;
import com.huayu.mapper.CommercialMapper;
import com.huayu.mapper.ContractMapper;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Contract;
import com.huayu.service.imp.ICommercialServiceImp;
import com.huayu.service.imp.IContractServiceImp;
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


 @Override
 public boolean updatec(Commercial commercial) {
  return commercialMapper.updatec(commercial);
 }
 public List<CommercialBo> queryCom(){
/*  CommercialBo commercialBo=new CommercialBo();
  List<CommercialBo>  commercialBoList=new ArrayList<>();
  List<Commercial> commercials=commercialMapper.selectList(null);*/
  List<CommercialBo> commercialBoList= commercialMapper.queryComm();
  for ( CommercialBo commercialBo :commercialBoList ){
   System.out.println(commercialBo.getConameCliNname());
   System.out.println(commercialBo.getComUname());
  }

 return commercialBoList;
 }
}
