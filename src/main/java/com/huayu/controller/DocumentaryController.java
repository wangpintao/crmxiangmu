package com.huayu.controller;

import com.huayu.pojo.Documentary;
import com.huayu.pojo.User;
import com.huayu.service.imp.IDocumentaryServiceImp;
import com.huayu.service.imp.IUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/documentary")
public class DocumentaryController {
    @Autowired
    private IDocumentaryServiceImp iDocumentaryServiceImp;
    @RequestMapping("/queryall.do")
    @ResponseBody
    public List<Documentary> queryall(){
        return iDocumentaryServiceImp.list();
    }
}
