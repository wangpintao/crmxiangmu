package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.UserMapper;
import com.huayu.mapper.UserRoleMapper;
import com.huayu.pojo.User;
import com.huayu.pojo.UserRole;
import com.huayu.service.imp.IUserRoleServiceImp;
import com.huayu.service.imp.IUserServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRoleService extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleServiceImp {

}
