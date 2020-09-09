package com.huayu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.JsonUtils.StulayuiJson;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.Contract;
import com.huayu.pojo.Forum;
import com.huayu.pojo.UserClien;
import com.huayu.service.imp.IContractServiceImp;
import com.huayu.service.imp.IForumServiceImp;
import com.huayu.service.imp.IUserClienServiceImp;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractServiceImp iContractServiceImp;
    @Autowired
    private IUserClienServiceImp iUserClienServiceImp;

    @RequestMapping("/queryall.do")
    @ResponseBody
    public Stulayui queryall(Integer page, Integer limit, Contract contract){
        System.out.println(contract);
        Stulayui stulayui=new Stulayui();
        Page<Contract> page1=new Page<>(page,limit);
        List<Contract> list=iContractServiceImp.queryall(page1,contract);
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
    public String queryall(Model model){
        model.addAttribute("list",iUserClienServiceImp.list());
        return "/contract/add.html";
    }

    @PostMapping("/user.do")
    @ResponseBody
    public StulayuiJson user(Integer ucid){
        StulayuiJson stulayuiJson=new StulayuiJson();
        stulayuiJson.setData(iUserClienServiceImp.selectId(ucid));
        return stulayuiJson;
    }
}
