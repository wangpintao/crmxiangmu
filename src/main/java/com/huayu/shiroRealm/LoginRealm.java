package com.huayu.shiroRealm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.pojo.Permission;
import com.huayu.pojo.User;
import com.huayu.pojo.UserRole;
import com.huayu.service.imp.IUserServiceImp;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoginRealm extends AuthorizingRealm {
    @Autowired
    private IUserServiceImp iUserServiceImlp;//用户mappers

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //把AuthenticationToken转为UsernamePasswordToken拿到用户名
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        User user = iUserServiceImlp.getOne(queryWrapper);
        if (user == null){
            throw new UnknownAccountException("你访问了一个未知的用户");
        }
        //第三个字段是realm，即当前realm的名称
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
        return simpleAuthenticationInfo;
    }
}
