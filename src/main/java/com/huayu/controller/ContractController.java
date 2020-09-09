package com.huayu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.JsonUtils.StulayuiJson;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.Contract;
import com.huayu.pojo.Forum;
import com.huayu.pojo.User;
import com.huayu.pojo.UserClien;
import com.huayu.service.imp.*;
import io.swagger.models.auth.In;
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
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractServiceImp iContractServiceImp;
    @Autowired
    private IUserClienServiceImp iUserClienServiceImp;
    @Autowired
    private IUserServiceImp iUserServiceImp;
    @Autowired
    private IUserDepartmentServiceImp iUserDepartmentServiceImp;

    @RequestMapping("/queryall.do")
    @ResponseBody
    public Stulayui queryall(Integer page, Integer limit, Contract contract) {
        Stulayui stulayui = new Stulayui();
        Page<Contract> page1 = new Page<>(page, limit);
        List<Contract> list = iContractServiceImp.queryall(page1, contract);
        if (list.size() > 0) {
            stulayui.setCode(0);
            stulayui.setMsg("查询成功");
            stulayui.setCount(list.size());
            stulayui.setData(list);
        } else {
            stulayui.setCode(1);
            stulayui.setMsg("无数据");
            stulayui.setCount(list.size());
            stulayui.setData(list);
        }
        return stulayui;
    }

    @RequestMapping("/add.do")
    public String add(Model model) {
        model.addAttribute("list", iUserClienServiceImp.list());
        return "/contract/add.html";
    }

    @PostMapping("/user.do")
    @ResponseBody
    public StulayuiJson user(Integer ucid) {
        StulayuiJson stulayuiJson = new StulayuiJson();
        stulayuiJson.setData(iUserClienServiceImp.selectId(ucid));
        return stulayuiJson;
    }

    @RequestMapping("/add1.do")
    public String add1(@RequestParam("file") MultipartFile docfile, Contract contract, HttpServletRequest request) {
        try {
            String oriName = docfile.getOriginalFilename();
            if (oriName.length()!=0) {
                String path = request.getServletContext().getRealPath("/upload");
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                docfile.transferTo(new File(path, oriName));
                contract.setConFile(oriName);
            } else {
                contract.setConFile("无附件");
            }
            iContractServiceImp.save(contract);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/contract/contract.html";
    }

    @RequestMapping("/update.do")
    public String update(Contract contract,Model model) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("conid",contract.getConid());
        model.addAttribute("con",iContractServiceImp.getOne(queryWrapper));
        QueryWrapper queryWrapper1=new QueryWrapper();
        queryWrapper1.eq("ucid",contract.getConUcid());
        model.addAttribute("user",iUserClienServiceImp.getOne(queryWrapper1));
        QueryWrapper queryWrapper2=new QueryWrapper();
        queryWrapper2.eq("uid",contract.getConUid());
        User user=iUserServiceImp.getOne(queryWrapper2);
        model.addAttribute("u",user);
        QueryWrapper queryWrapper3=new QueryWrapper();
        queryWrapper3.eq("udid",user.getDepid());
        model.addAttribute("d",iUserDepartmentServiceImp.getOne(queryWrapper3));
        return "/contract/update.html";
    }
}
