package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.CliKindMapper;
import com.huayu.mapper.CliSourceMapper;
import com.huayu.pojo.CliKind;
import com.huayu.pojo.CliSource;
import com.huayu.service.imp.ICliKindServiceImp;
import com.huayu.service.imp.ICliSourceServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CliKindService extends ServiceImpl<CliKindMapper, CliKind> implements ICliKindServiceImp {


}
