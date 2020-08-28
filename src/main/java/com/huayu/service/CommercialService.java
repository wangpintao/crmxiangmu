package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.CommercialMapper;
import com.huayu.mapper.ContractMapper;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Contract;
import com.huayu.service.imp.ICommercialServiceImp;
import com.huayu.service.imp.IContractServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommercialService extends ServiceImpl<CommercialMapper, Commercial> implements ICommercialServiceImp {


}
