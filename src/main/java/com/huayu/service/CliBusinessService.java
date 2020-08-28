package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.CliBusinessMapper;
import com.huayu.mapper.CliKindMapper;
import com.huayu.pojo.CliBusiness;
import com.huayu.pojo.CliKind;
import com.huayu.service.imp.ICliBusinessServiceImp;
import com.huayu.service.imp.ICliKindServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CliBusinessService extends ServiceImpl<CliBusinessMapper, CliBusiness> implements ICliBusinessServiceImp {


}
