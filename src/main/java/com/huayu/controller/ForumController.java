package com.huayu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Forum;
import com.huayu.service.imp.ICommercialServiceImp;
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
    public Stulayui queryall(Integer page,Integer limit,Forum forum){
        return iForumServiceImp.queryall(page,limit,forum);
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
            forum.setForForid(0);
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
        forum.setForClick(forum.getForClick()+1);
        iForumServiceImp.updateone1(forum);
        QueryWrapper queryWrapper1=new QueryWrapper();
        queryWrapper1.eq("for_forid",forid);
        List<Forum> list=iForumServiceImp.list(queryWrapper1);
        if(list.size()>0){
            for (int i =0; i <list.size() ; i++) {
                list.get(i).setForClick(i+1);
            }
        }
        model.addAttribute("forum",forum);
        model.addAttribute("list",list);
        return "/forum/update";
    }

    @RequestMapping("/delete.do")
    public String delete(Integer forid){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("forid",forid);
        iForumServiceImp.remove(queryWrapper);
        return "redirect:/forum/forum.html";
    }

    @RequestMapping("/set.do")
    public String set(Integer forid,Model model){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("forid",forid);
        model.addAttribute("forum",iForumServiceImp.getOne(queryWrapper));
        return "/forum/set.html";
    }

    @PostMapping("/set1.do")
    public String set1(Forum forum,Model model){
        iForumServiceImp.updateone(forum);
        return "redirect:/forum/forum.html";
    }

    @RequestMapping("/update1.do")
    public String update1(Forum forum,Model model){
        forum.setForAuthor("安娜");
        forum.setForDate(new Date());
        Forum forum1=new Forum();
        forum1.setForid(forum.getForForid());
        forum1.setForFinally(new Date());
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("forid",forum.getForForid());
        Forum forum2=iForumServiceImp.getOne(queryWrapper);
        forum1.setForReply(forum2.getForReply()+1);
        boolean b=iForumServiceImp.save(forum);
        if(b){
            iForumServiceImp.updateone2(forum1);
        }
        return "redirect:/forum/update.do?forid="+forum.getForForid();
    }



}
