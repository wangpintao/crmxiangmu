package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.AfterSaleMapper;
import com.huayu.mapper.CliBusinessMapper;
import com.huayu.pojo.AfterSale;
import com.huayu.pojo.CliBusiness;
import com.huayu.service.imp.IAfterSaleServiceImp;
import com.huayu.service.imp.ICliBusinessServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AfterSaleService extends ServiceImpl<AfterSaleMapper, AfterSale> implements IAfterSaleServiceImp {


}
