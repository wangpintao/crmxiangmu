package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.bo.FunnelStatisticsBo;
import com.huayu.mapper.CliBusinessMapper;
import com.huayu.mapper.CliKindMapper;
import com.huayu.pojo.CliBusiness;
import com.huayu.pojo.CliKind;
import com.huayu.service.imp.ICliBusinessServiceImp;
import com.huayu.service.imp.ICliKindServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CliBusinessService extends ServiceImpl<CliBusinessMapper, CliBusiness> implements ICliBusinessServiceImp {

    @Autowired
    private CliBusinessMapper cliBusinessMapper;

    @Override
    public List<FunnelStatisticsBo> queryIndustry(){
        return cliBusinessMapper.queryIndustry();
    }
}
