package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.PermissionMapper;
import com.huayu.mapper.RolePermMapper;
import com.huayu.pojo.Permission;
import com.huayu.pojo.RolePerm;
import com.huayu.service.imp.IPermissionServiceImp;
import com.huayu.service.imp.IRolePermServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermissionService extends ServiceImpl<PermissionMapper, Permission> implements IPermissionServiceImp {

}
