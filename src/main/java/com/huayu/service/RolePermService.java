package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.RoleMapper;
import com.huayu.mapper.RolePermMapper;
import com.huayu.pojo.Role;
import com.huayu.pojo.RolePerm;
import com.huayu.service.imp.IRolePermServiceImp;
import com.huayu.service.imp.IRoleServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolePermService extends ServiceImpl<RolePermMapper, RolePerm> implements IRolePermServiceImp {

}
