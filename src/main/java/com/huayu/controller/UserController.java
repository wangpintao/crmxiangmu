package com.huayu.controller;

import com.huayu.pojo.User;
import com.huayu.service.imp.IUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserServiceImp iUserServiceImp;
    @RequestMapping("/query.do")
    @ResponseBody
    public User query(Integer uid){
       return iUserServiceImp.getById(uid);
    }
    @RequestMapping("/queryall.do")
    @ResponseBody
    public List<User> queryall(){
        return iUserServiceImp.list();
    }
}
