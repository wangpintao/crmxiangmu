package com.huayu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.DocClassify;
import com.huayu.pojo.Documentary;
import com.huayu.pojo.Forum;
import com.huayu.service.imp.ICommercialServiceImp;
import com.huayu.service.imp.IDocumentaryServiceImp;
import com.huayu.service.imp.IForumServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private IForumServiceImp iForumServiceImp;
    @Autowired
    private ICommercialServiceImp iCommercialServiceImp;

    @RequestMapping("/queryall.do")
    @ResponseBody
    public Stulayui queryall(){
        Stulayui stulayui=new Stulayui();
        QueryWrapper queryWrapper=new QueryWrapper();
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

    @RequestMapping("/add.do")
    public String add(Model model){
        //商机主题
        List<Commercial> list=iCommercialServiceImp.list();
        model.addAttribute("shang",list);
        return "/forum/add";
    }

    @PostMapping("/add1.do")
    public String add1(@RequestParam("file") MultipartFile docfile,Forum forum,HttpServletRequest request){
        try {
            if(docfile.getSize()>0){
                String oriName = docfile.getOriginalFilename();
                String path = request.getServletContext().getRealPath("/upload");
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                docfile.transferTo(new File(path,oriName));
                forum.setForFile(oriName);
            }else{
                forum.setForFile("无附件");
            }
            forum.setForDate(new Date());
            forum.setForAuthor("李娜");
            forum.setForClick(1);
            forum.setForReply(0);
            iForumServiceImp.save(forum);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/forum/forum.html";
    }

    @RequestMapping("/update.do")
    public String update(Integer forid,Model model){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("forid",forid);
        Forum forum=iForumServiceImp.getOne(queryWrapper);
        model.addAttribute("forum",forum);
        return "/forum/update";
    }

    @RequestMapping("/delete.do")
    public String delete(Integer forid){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("forid",forid);
        iForumServiceImp.remove(queryWrapper);
        return "redirect:/forum/forum.html";
    }



}
