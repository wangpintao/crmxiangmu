package com.huayu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.mapper.*;
import com.huayu.pojo.*;
import com.huayu.service.imp.IContractServiceImp;
import com.huayu.service.imp.IDocClassifyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ContractService extends ServiceImpl<ContractMapper, Contract> implements IContractServiceImp {
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private MinvoiceMapper minvoiceMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDepartmentMapper userDepartmentMapper;
    @Autowired
    private UserClienMapper userClienMapper;

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

    @Override
    public Integer add(MultipartFile docfile, Contract contract, HttpServletRequest request) {
        int flag=0;
        try {
            String oriName = docfile.getOriginalFilename();
            if (oriName.length()!=0) {
                String path = request.getServletContext().getRealPath("/upload");
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                docfile.transferTo(new File(path, oriName));
                contract.setConFile(oriName);
            } else {
                contract.setConFile("无附件");
            }
            contract.setConState(1);
            if(contractMapper.insert(contract)>0){
                flag=1;
                Contract contract1=queryone();
                Long l=Long.valueOf("0");
                QueryWrapper queryWrapper=new QueryWrapper();
                queryWrapper.eq("uid",contract1.getConUid());
                User user=userMapper.selectOne(queryWrapper);

                Register register=new Register();
                //合同id
                register.setrConid(contract1.getConid());
                //客户id
                register.setrUcid(contract1.getConUcid());
                //用户id
                register.setrUid(contract1.getConUid());
                //收入日期
                register.setrDate(new Date());
                //收入金额
                register.setrMoney(l);
                //关联人员
                register.setrName(contract1.getConUname());

                Minvoice minvoice=new Minvoice();
                //步骤
                minvoice.setmStep("填单");
                //用户id
                minvoice.setmUid(contract1.getConUid());
                //用户名
                minvoice.setmName(contract1.getConname());
                //申请金额
                minvoice.setmMoney(l);
                //申请时间
                minvoice.setmApplydate(new Date());
                //客户id
                minvoice.setmUcid(contract1.getConUcid());
                QueryWrapper queryWrapper2=new QueryWrapper();
                queryWrapper2.eq("",contract1.getConUcid());
                UserClien userClien=userClienMapper.selectOne(queryWrapper2);
                //客户名称
                minvoice.setmUcname(userClien.getCliName());

                if(user!=null){
                    if (user.getDepid()>0) {
                        //关联部门
                        register.setrDeptid(user.getDepid());
                        QueryWrapper queryWrapper1=new QueryWrapper();
                        queryWrapper1.eq("udid",user.getDepid());
                        UserDepartment userDepartment=userDepartmentMapper.selectOne(queryWrapper1);
                        //部门名称
                        minvoice.setmDname(userDepartment.getUdname());
                    }
                }
                if(registerMapper.insert(register)>0 && minvoiceMapper.insert(minvoice)>0){
                    Register register1=rone();
                    Minvoice minvoice1=mone();
                    contract1.setConRid(register1.getRid());
                    contract1.setConMid(minvoice1.getMid());
                    contract1.setConRmoney(l);
                    contract1.setConMmoney(l);
                }
                contractMapper.updateone(contract1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Contract queryone() {
        return contractMapper.queryone();
    }

    @Override
    public Register rone() {
        return contractMapper.rone();
    }

    @Override
    public Minvoice mone() {
        return contractMapper.mone();
    }
}
