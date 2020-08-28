package com.huayu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huayu.mapper.UserDepartmentMapper;
import com.huayu.mapper.UserMapper;
import com.huayu.pojo.User;
import com.huayu.pojo.UserDepartment;
import com.huayu.service.imp.IUserDepartmentServiceImp;
import com.huayu.service.imp.IUserServiceImp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDepartmentService extends ServiceImpl<UserDepartmentMapper, UserDepartment> implements IUserDepartmentServiceImp{

}
