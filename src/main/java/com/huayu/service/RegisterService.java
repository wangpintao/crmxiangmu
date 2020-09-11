package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.RegisterMapper;
import com.huayu.pojo.Register;
import com.huayu.service.imp.IRegisterServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 收入登记表 服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2020-09-11
 */
@Service
@Transactional
public class RegisterService extends ServiceImpl<RegisterMapper, Register> implements IRegisterServiceImp {

}
