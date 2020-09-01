package com.huayu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.JsonUtils.StulayuiJson;
import com.huayu.pojo.AfterSale;
import com.huayu.pojo.User;
import com.huayu.service.imp.IUserServiceImp;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.CodecException;
import org.apache.shiro.crypto.UnknownAlgorithmException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserServiceImp iUserServiceImp;

    //登录
    @RequestMapping("/login.do")
    @ResponseBody
    public StulayuiJson login(User user) {
        StulayuiJson stulayuiJson =new StulayuiJson();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        //拿到主体
        Subject subject = SecurityUtils.getSubject();
        try {
            stulayuiJson.setCode(1);
            //这个login方法在加工token的时候已经把自己写的realm加了进来，
            // realm就是一个装有数据的载体，把它装入SecurityManager，
            // 上面的subject的login方法就就可以完整的运行了
            subject.login(token);
            QueryWrapper queryWrapper =new QueryWrapper();
            queryWrapper.eq("username",user.getUsername());
            iUserServiceImp.getOne(queryWrapper);
        } catch (IncorrectCredentialsException e){
            stulayuiJson.setCode(2);
            System.out.println("密码错误");
            e.printStackTrace();
        } catch (AuthenticationException e) {
            stulayuiJson.setCode(3);
            System.out.println("认证异常，没有此用户");
            e.printStackTrace();
        }
        return stulayuiJson;
    }

    //查询用户
    @RequestMapping("/register.do")
    @ResponseBody
    public User register(String name){
        System.out.println("前端值"+name);
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("username",name);
        return iUserServiceImp.getOne(queryWrapper);
    }
    @RequestMapping("/useradd.do")
    @ResponseBody
    public StulayuiJson useradd(User user){
        StulayuiJson stulayuiJson = new StulayuiJson();
        try {
            stulayuiJson.setCode(1);
            iUserServiceImp.save(user);
        } catch (Exception e) {
            stulayuiJson.setCode(2);
            e.printStackTrace();
        }
        return stulayuiJson;
    }


    @GetMapping("/querytext.do")
    @ResponseBody
    public List<User> querytext(){
        List<User> afterSaleList = iUserServiceImp.list();
        return afterSaleList;
    }
}
