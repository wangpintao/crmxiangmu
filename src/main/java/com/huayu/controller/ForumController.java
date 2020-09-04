package com.huayu.controller;

import com.huayu.layuiUtils.Stulayui;
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
    public Stulayui queryall(){
        Stulayui stulayui=new Stulayui();
        List<Forum> list=iForumServiceImp.list();
        if(list.size()>0){
            stulayui.setCode(0);
            stulayui.setMsg("查询成功");
            stulayui.setCount(list.size());
            stulayui.setData(list);
        }else{
            stulayui.setCode(1);
            stulayui.setMsg("无数据");
            stulayui.setCount(list.size());
            stulayui.setData(list);
        }
        return stulayui;
    }
}
