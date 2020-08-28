package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.RoleMapper;
import com.huayu.mapper.UserMapper;
import com.huayu.pojo.Role;
import com.huayu.pojo.User;
import com.huayu.service.imp.IRoleServiceImp;
import com.huayu.service.imp.IUserServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleServiceImp {

}
