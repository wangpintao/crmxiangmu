package com.huayu.controller;

import com.huayu.pojo.Documentary;
import com.huayu.pojo.Forum;
import com.huayu.service.imp.IDocumentaryServiceImp;
import com.huayu.service.imp.IForumServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private IForumServiceImp iForumServiceImp;
    @RequestMapping("/queryall.do")
    @ResponseBody
    public List<Forum> queryall(){
        return iForumServiceImp.list();
    }
}
