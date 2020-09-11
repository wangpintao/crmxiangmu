package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.bo.FunnelStatisticsBo;
import com.huayu.mapper.CliSourceMapper;
import com.huayu.mapper.CommercialMapper;
import com.huayu.pojo.CliSource;
import com.huayu.pojo.Commercial;
import com.huayu.service.imp.ICliSourceServiceImp;
import com.huayu.service.imp.ICommercialServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CliSourceService extends ServiceImpl<CliSourceMapper, CliSource> implements ICliSourceServiceImp {

    @Autowired
    private CliSourceMapper cliSourceMapper;

    @Override
    public List<FunnelStatisticsBo> querySource(){
        return cliSourceMapper.querySource();
    }

}
