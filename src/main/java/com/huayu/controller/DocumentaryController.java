package com.huayu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.DocClassify;
import com.huayu.pojo.Documentary;
import com.huayu.pojo.User;
import com.huayu.service.imp.ICommercialServiceImp;
import com.huayu.service.imp.IDocClassifyServiceImp;
import com.huayu.service.imp.IDocumentaryServiceImp;
import com.huayu.service.imp.IUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/documentary")
public class DocumentaryController {
    @Autowired
    private IDocumentaryServiceImp iDocumentaryServiceImp;
    @Autowired
    private ICommercialServiceImp iCommercialServiceImp;
    @Autowired
    private IDocClassifyServiceImp iDocClassifyServiceImp;

    @RequestMapping("/queryall.do")
    @ResponseBody
    public Stulayui queryall(Integer page,Integer limit,Documentary documentary){
        documentary.setDocuser(1);
        Stulayui stulayui=new Stulayui();
        Page<Documentary> page1=new Page<>(page,limit);
        List<Documentary> list=iDocumentaryServiceImp.queryall(page1,documentary);
        if(list.size()>0){
            stulayui.setCode(0);
            stulayui.setMsg("查询成功");
            stulayui.setCount(list.size());
            stulayui.setData(list);
        }else{
            stulayui.setCode(1);
            stulayui.setMsg("查询失败");
            stulayui.setCount(list.size());
            stulayui.setData(list);
        }
        return stulayui;
    }

    @RequestMapping("/add.do")
    public String add(Model model){
        //商机主题
        List<Commercial> list=iCommercialServiceImp.list();
        //跟单分类
        List<DocClassify> list1=iDocClassifyServiceImp.list();
        System.out.println(list+"=="+list1);
        model.addAttribute("shang",list);
        model.addAttribute("gen",list1);

        return "forward:/documentary/documentaryadd.html";
    }

    @PostMapping("/add1.do")
    public String add1(Documentary documentary){
        iDocumentaryServiceImp.save(documentary);

        return "/documentary/documentary.html";
    }
}
