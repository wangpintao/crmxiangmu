package com.huayu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.mapper.ContractMapper;
import com.huayu.mapper.DocClassifyMapper;
import com.huayu.pojo.Contract;
import com.huayu.pojo.DocClassify;
import com.huayu.pojo.Forum;
import com.huayu.service.imp.IContractServiceImp;
import com.huayu.service.imp.IDocClassifyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ContractService extends ServiceImpl<ContractMapper, Contract> implements IContractServiceImp {
    @Autowired
    private ContractMapper contractMapper;

    //根据合同编号来查询合同信息。
    @Override
    public Contract queryByConId(String serial) {
        return contractMapper.queryByConId(serial);
    }

    @Override
    public Stulayui queryall(Integer page, Integer limit, Contract contract) {
        Stulayui stulayui = new Stulayui();
        Page page1 = PageHelper.startPage(page,limit);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("con_uid",1);
        if(null!=contract){
            if(!StringUtil.isEmpty(contract.getSerial())){
                if(contract.getSerial().equals("conname")){
                    queryWrapper.like(contract.getSerial(),contract.getConname());
                }else if(contract.getSerial().equals("serial")){
                    queryWrapper.like(contract.getSerial(),contract.getConname());
                }else if(contract.getSerial().equals("con_uname")){
                    queryWrapper.like(contract.getSerial(),contract.getConname());
                }else if(contract.getSerial().equals("con_sum")){
                    queryWrapper.eq(contract.getSerial(),contract.getConname());
                }else if(contract.getSerial().equals("con_startdate")){
                    queryWrapper.eq(contract.getSerial(),contract.getConname());
                }
            }
        }
        List<Contract> list = contractMapper.selectList(queryWrapper);
        if (list.size() > 0) {
            stulayui.setCode(0);
            stulayui.setMsg("查询成功");
            stulayui.setCount(Integer.valueOf(String.valueOf(page1.getTotal())));
            stulayui.setData(list);
        } else {
            stulayui.setCode(1);
            stulayui.setMsg("无数据");
        }
        return stulayui;
    }

    @Override
    public Stulayui queryalls(Integer page, Integer limit, Contract contract) {
        Stulayui stulayui = new Stulayui();
        Page page1 = PageHelper.startPage(page,limit);
        QueryWrapper queryWrapper=new QueryWrapper();
        if(null!=contract){
            if(!StringUtil.isEmpty(contract.getSerial())){
                if(contract.getSerial().equals("conname")){
                    queryWrapper.like(contract.getSerial(),contract.getConname());
                }else if(contract.getSerial().equals("serial")){
                    queryWrapper.like(contract.getSerial(),contract.getConname());
                }else if(contract.getSerial().equals("con_uname")){
                    queryWrapper.like(contract.getSerial(),contract.getConname());
                }else if(contract.getSerial().equals("con_sum")){
                    queryWrapper.eq(contract.getSerial(),contract.getConname());
                }else if(contract.getSerial().equals("con_startdate")){
                    queryWrapper.eq(contract.getSerial(),contract.getConname());
                }
            }
        }
        List<Contract> list = contractMapper.selectList(queryWrapper);
        if (list.size() > 0) {
            stulayui.setCode(0);
            stulayui.setMsg("查询成功");
            stulayui.setCount(Integer.valueOf(String.valueOf(page1.getTotal())));
            stulayui.setData(list);
        } else {
            stulayui.setCode(1);
            stulayui.setMsg("无数据");
        }
        return stulayui;
    }

    @Override
    public Integer updateone(Contract contract) {
        return contractMapper.updateone(contract);
    }

    @Override
    public Stulayui queryBya(Integer page, Integer limit, Contract contract) {
        Stulayui stulayui=new Stulayui();
        Page page1 = PageHelper.startPage(page,limit);
        List<Contract> list=new ArrayList<>();
        QueryWrapper queryWrapper=new QueryWrapper();
        if(null!=contract) {
            if (!StringUtil.isEmpty(contract.getClause())) {
                if (contract.getClause().equals("week")) {
                    list = contractMapper.newWeek();
                } else if (contract.getClause().equals("lastWeek")) {
                    list = contractMapper.beforeWeek();
                } else if (contract.getClause().equals("month")) {
                    list = contractMapper.newMonth();
                } else if (contract.getClause().equals("lastMonth")) {
                    list = contractMapper.beforeMonth();
                } else if (contract.getClause().equals("quarter")) {
                    list = contractMapper.newSeason();
                } else if (contract.getClause().equals("lastQuarter")) {
                    list = contractMapper.beforeSeason();
                } else if (contract.getClause().equals("queryAll")){
                    list = contractMapper.selectList(queryWrapper);
                } else {
                    queryWrapper.eq("con_state",contract.getClause());
                    list = contractMapper.selectList(queryWrapper);
                }
            }else {
                list=contractMapper.selectList(queryWrapper);
            }
        }else{
            list=contractMapper.selectList(queryWrapper);
        }
        if(list.size()>0){
            stulayui.setCode(0);
            stulayui.setMsg("查询成功");
            stulayui.setCount(Integer.valueOf(String.valueOf(page1.getTotal())));
            stulayui.setData(list);
        }else{
            stulayui.setCode(1);
            stulayui.setMsg("无数据");
        }
        return stulayui;
    }

    @Override
    public List<Integer> queryCount() {
        List<Integer> count =new ArrayList<>();
        for (int i =1 ;i<=4 ;i++){
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("con_state", i);
            count.add(contractMapper.selectList(queryWrapper).size());
        }
        count.add(contractMapper.newWeek().size());
        count.add(contractMapper.beforeWeek().size());
        count.add(contractMapper.newMonth().size());
        count.add(contractMapper.beforeMonth().size());
        count.add(contractMapper.newSeason().size());
        count.add(contractMapper.beforeSeason().size());
        return count;
    }
}
