package com.huayu.controller;

import com.huayu.pojo.Contract;
import com.huayu.pojo.Forum;
import com.huayu.service.imp.IContractServiceImp;
import com.huayu.service.imp.IForumServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractServiceImp iContractServiceImp;
    @RequestMapping("/queryall.do")
    @ResponseBody
    public List<Contract> queryall(){
        return iContractServiceImp.list();
    }
}
