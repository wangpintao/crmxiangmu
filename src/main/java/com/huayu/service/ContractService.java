package com.huayu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

import java.util.List;

@Service
@Transactional
public class ContractService extends ServiceImpl<ContractMapper, Contract> implements IContractServiceImp {

    @Autowired
    private ContractMapper contractMapper;

    //根据合同编号来查询合同信息
    @Override
    public Contract queryByConId(String serial) {
        return contractMapper.queryByConId(serial);
    }

    @Override
    public List<Contract> queryall(IPage<Contract> page, Contract contract) {
        return contractMapper.queryall(page,contract);
    }
}
