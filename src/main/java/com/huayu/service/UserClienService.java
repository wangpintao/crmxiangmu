package com.huayu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.huayu.bo.ClientBo;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.mapper.*;
import com.huayu.pojo.*;
import com.huayu.service.imp.IUserClienServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserClienService extends ServiceImpl<UserClienMapper,UserClien> implements IUserClienServiceImp {
 @Autowired
 private UserClienMapper userClienMapper;

 @Autowired
 private CommercialMapper commercialMapper;

 @Autowired
 private ContractMapper contractMapper;

 @Autowired
 private AfterSaleMapper afterSaleMapper;

 @Override
 public UserClien selectId(Integer ucid){
  return userClienMapper.selectId(ucid);
 }

 @Override
 public List<UserClien> listUser() {
  return userClienMapper.listUser();
 }

 /*客户联和
 * */
 @Override
 public Stulayui queryMany(Integer page,Integer limit,String clientid ,String keys) {
   Stulayui stulayui=new Stulayui();
   List<ClientBo> clientBoList=new ArrayList<>();
   //Page page1 = PageHelper.startPage(page,limit);
   if(page==null){
    page=1;
   }
   IPage<UserClien> page1=new Page(page,limit);
   QueryWrapper wrapper5=new QueryWrapper();
     if (!StringUtils.isEmpty(clientid) && !StringUtils.isEmpty(keys)){
     wrapper5.like(clientid,keys);
    }
   IPage iPage= userClienMapper.selectPage(page1,wrapper5);
   List<UserClien> clienList=iPage.getRecords();
   for(UserClien cli:clienList){
    ClientBo clientBo=new ClientBo();
    Integer ucid= cli.getUcid();
    QueryWrapper wrapper=new QueryWrapper();
    wrapper.eq("ucid",ucid);
    UserClien userClien=userClienMapper.selectOne(wrapper);
    //客户名称
    clientBo.setCliName(userClien.getCliName());

    QueryWrapper wrapper1=new QueryWrapper();
    wrapper1.eq("com_ucid",ucid);
    List<Commercial> commercial=commercialMapper.selectList(wrapper1);
    //商机数
    clientBo.setCsum(commercial.size());
    //预计成交金额
    Long csum=0L;
    for(Commercial com:commercial){
     csum+= com.getComSum();
    }
    clientBo.setComSum(csum);

    QueryWrapper wrapper2=new QueryWrapper();
    wrapper2.eq("con_ucid",ucid);
    List<Contract> contracts=contractMapper.selectList(wrapper2);
    //合同数
    clientBo.setConCount(contracts.size());
    Long cosum=0L;
   //合同金额
    for(Contract con:contracts){
     cosum+=con.getConSum();
    }
   clientBo.setConSum(cosum);

    //汇款额


    QueryWrapper wrapper3=new QueryWrapper();
    wrapper3.eq("aft_ucid",ucid);
    List<AfterSale> afterSales=afterSaleMapper.selectList(wrapper3);
    int  aftc=afterSales.size();
    //售后服务数
    clientBo.setAftCount(afterSales.size());
    //服务评分
    Float afts=0.0F;
    Float aftcs=0.0F;
    for(AfterSale aft:afterSales){
     afts+=aft.getAftScore();
     aftcs=afts/aftc;
    }
    clientBo.setAftScore(aftcs);
    clientBoList.add(clientBo);
   }
  stulayui.setMsg("查询成功");
  stulayui.setCode(0);
  stulayui.setCount(Integer.valueOf(String.valueOf(page1.getTotal())));
  stulayui.setData(clientBoList);
  return stulayui;
 }

 @Override
 public UserClien queryByid(Integer ucid) {
  return userClienMapper.queryByid(ucid);
 }

 @Override
 public boolean updatecl(UserClien userClien) {
  return userClienMapper.updatecl(userClien) ;
 }
}
