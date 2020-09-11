package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.MinvoiceMapper;
import com.huayu.pojo.Minvoice;
import com.huayu.service.imp.IMinvoiceServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 开票申请表 服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2020-09-11
 */
@Service
@Transactional
public class MinvoiceService extends ServiceImpl<MinvoiceMapper, Minvoice> implements IMinvoiceServiceImp {

}
