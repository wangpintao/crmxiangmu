package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.CliSourceMapper;
import com.huayu.mapper.CommercialMapper;
import com.huayu.pojo.CliSource;
import com.huayu.pojo.Commercial;
import com.huayu.service.imp.ICliSourceServiceImp;
import com.huayu.service.imp.ICommercialServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CliSourceService extends ServiceImpl<CliSourceMapper, CliSource> implements ICliSourceServiceImp {


}
