package com.huayu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huayu.JsonUtils.StulayuiJson;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.*;
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
    @Autowired
    private IRegisterServiceImp iRegisterServiceImp;
    @Autowired
    private IMinvoiceServiceImp iMinvoiceServiceImp;

    @RequestMapping("/queryall.do")
    @ResponseBody
    public Stulayui queryall(Integer page, Integer limit, Contract contract) {
        return iContractServiceImp.queryall(page,limit,contract);
    }

    @RequestMapping("/queryalls.do")
    @ResponseBody
    public Stulayui queryalls(Integer page, Integer limit, Contract contract) {
        return iContractServiceImp.queryalls(page,limit,contract);
    }

    @RequestMapping("/add.do")
    public String add(Model model) {
        model.addAttribute("list", iUserClienServiceImp.list());
        return "/contract/add.html";
    }

    @RequestMapping("/adds.do")
    public String adds(Model model) {
        model.addAttribute("list", iUserClienServiceImp.list());
        return "/contract/add1.html";
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
        iContractServiceImp.add(docfile,contract,request);
        return "redirect:/contract/contract.html";
    }

    @RequestMapping("/add1s.do")
    public String add1s(@RequestParam("file") MultipartFile docfile, Contract contract, HttpServletRequest request) {
        iContractServiceImp.add(docfile,contract,request);
        return "redirect:/contract/contracts.html";
    }

    @RequestMapping("/update.do")
    public String update(Contract contract,Model model) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("conid",contract.getConid());
        model.addAttribute("con",iContractServiceImp.getOne(queryWrapper));
        model.addAttribute("user",iUserClienServiceImp.selectId(contract.getConUcid()));
        QueryWrapper queryWrapper2=new QueryWrapper();
        queryWrapper2.eq("uid",contract.getConUid());
        User user=iUserServiceImp.getOne(queryWrapper2);
        model.addAttribute("u",user);
        QueryWrapper queryWrapper3=new QueryWrapper();
        queryWrapper3.eq("udid",user.getDepid());
        model.addAttribute("d",iUserDepartmentServiceImp.getOne(queryWrapper3));
        return "/contract/update.html";
    }

    @RequestMapping("/updates.do")
    public String updates(Contract contract,Model model) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("conid",contract.getConid());
        model.addAttribute("con",iContractServiceImp.getOne(queryWrapper));
        model.addAttribute("user",iUserClienServiceImp.selectId(contract.getConUcid()));
        QueryWrapper queryWrapper2=new QueryWrapper();
        queryWrapper2.eq("uid",contract.getConUid());
        User user=iUserServiceImp.getOne(queryWrapper2);
        model.addAttribute("u",user);
        QueryWrapper queryWrapper3=new QueryWrapper();
        queryWrapper3.eq("udid",user.getDepid());
        model.addAttribute("d",iUserDepartmentServiceImp.getOne(queryWrapper3));
        return "/contract/update1.html";
    }

    @RequestMapping("/update1.do")
    public String update1(@RequestParam("file") MultipartFile docfile,Contract contract,HttpServletRequest request) {
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
            iContractServiceImp.updateone(contract);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/contract/contract.html";
    }

    @RequestMapping("/update1s.do")
    public String update1s(@RequestParam("file") MultipartFile docfile,Contract contract,HttpServletRequest request) {
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
            iContractServiceImp.updateone(contract);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/contract/contracts.html";
    }

    @RequestMapping("/queryBya.do")
    @ResponseBody
    public Stulayui queryBya(Integer page,Integer limit,Contract contract) {
        return iContractServiceImp.queryBya(page,limit,contract);
    }

    @RequestMapping("/queryCount.do")
    @ResponseBody
    public List<Integer> queryCount(){
        return iContractServiceImp.queryCount();
    }

    @RequestMapping("/rupdate.do")
    public String rupdate(Contract contract,Model model) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("rid",contract.getConRid());
        Register register=iRegisterServiceImp.getOne(queryWrapper);
        model.addAttribute("reg",register);
        QueryWrapper queryWrapper2=new QueryWrapper();
        queryWrapper2.eq("uid",register.getrUid());
        model.addAttribute("user",iUserServiceImp.getOne(queryWrapper2));
        QueryWrapper queryWrapper3=new QueryWrapper();
        queryWrapper3.eq("udid",register.getrDeptid());
        model.addAttribute("dept",iUserDepartmentServiceImp.getOne(queryWrapper3));
        QueryWrapper queryWrapper4=new QueryWrapper();
        queryWrapper4.eq("ucid",register.getrUcid());
        model.addAttribute("uc",iUserClienServiceImp.getOne(queryWrapper4));
        QueryWrapper queryWrapper5=new QueryWrapper();
        queryWrapper5.eq("conid",register.getrConid());
        model.addAttribute("con",iContractServiceImp.getOne(queryWrapper5));
        return "/contract/register.html";
    }

    @RequestMapping("/rupdates.do")
    public String rupdates(Contract contract,Model model) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("rid",contract.getConRid());
        Register register=iRegisterServiceImp.getOne(queryWrapper);
        model.addAttribute("reg",register);
        QueryWrapper queryWrapper2=new QueryWrapper();
        queryWrapper2.eq("uid",register.getrUid());
        model.addAttribute("user",iUserServiceImp.getOne(queryWrapper2));
        QueryWrapper queryWrapper3=new QueryWrapper();
        queryWrapper3.eq("udid",register.getrDeptid());
        model.addAttribute("dept",iUserDepartmentServiceImp.getOne(queryWrapper3));
        QueryWrapper queryWrapper4=new QueryWrapper();
        queryWrapper4.eq("ucid",register.getrUcid());
        model.addAttribute("uc",iUserClienServiceImp.getOne(queryWrapper4));
        QueryWrapper queryWrapper5=new QueryWrapper();
        queryWrapper5.eq("conid",register.getrConid());
        model.addAttribute("con",iContractServiceImp.getOne(queryWrapper5));
        return "/contract/registers.html";
    }

    @PostMapping("/rupdate1.do")
    public String rupdate1(Register register) {
        System.out.println(register);
        iContractServiceImp.rupdate(register);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("con_rid",register.getRid());
        Contract contract=iContractServiceImp.getOne(queryWrapper);
        contract.setConRmoney(register.getrMoney());
        iContractServiceImp.updateone(contract);
        return "redirect:/contract/contract.html";
    }

    @PostMapping("/rupdate1s.do")
    public String rupdate1s(Register register) {
        System.out.println(register);
        iContractServiceImp.rupdate(register);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("con_rid",register.getRid());
        Contract contract=iContractServiceImp.getOne(queryWrapper);
        contract.setConRmoney(register.getrMoney());
        iContractServiceImp.updateone(contract);
        return "redirect:/contract/contract.html";
    }

    @RequestMapping("/mupdate.do")
    public String mupdate(Contract contract,Model model) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("mid",contract.getConMid());
        model.addAttribute("min",iMinvoiceServiceImp.getOne(queryWrapper));
        return "/contract/minvoice.html";
    }

    @RequestMapping("/mupdates.do")
    public String mupdates(Contract contract,Model model) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("mid",contract.getConMid());
        model.addAttribute("min",iMinvoiceServiceImp.getOne(queryWrapper));
        return "/contract/minvoices.html";
    }

    @PostMapping("/mupdate1.do")
    public String mupdate1(@RequestParam("file") MultipartFile docfile,@RequestParam("file1") MultipartFile docfile1,Minvoice minvoice,HttpServletRequest request) {
        try {
            String oriName = docfile.getOriginalFilename();
            if (oriName.length()!=0) {
                String path = request.getServletContext().getRealPath("/upload");
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                docfile.transferTo(new File(path, oriName));
                minvoice.setmRelefile(oriName);
            } else {
                minvoice.setmRelefile("无附件");
            }
            String oriName1 = docfile1.getOriginalFilename();
            if (oriName1.length()!=0) {
                String path = request.getServletContext().getRealPath("/upload");
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                docfile1.transferTo(new File(path, oriName1));
                minvoice.setmFile(oriName1);
            } else {
                minvoice.setmFile("无附件");
            }
            iContractServiceImp.mupdate(minvoice);
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("con_mid",minvoice.getMid());
            Contract contract=iContractServiceImp.getOne(queryWrapper);
            contract.setConMmoney(minvoice.getmMoney());
            iContractServiceImp.updateone(contract);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/contract/contract.html";
    }

    @PostMapping("/mupdate1s.do")
    public String mupdate1s(@RequestParam("file") MultipartFile docfile,@RequestParam("file1") MultipartFile docfile1,Minvoice minvoice,HttpServletRequest request) {
        try {
            String oriName = docfile.getOriginalFilename();
            if (oriName.length()!=0) {
                String path = request.getServletContext().getRealPath("/upload");
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                docfile.transferTo(new File(path, oriName));
                minvoice.setmRelefile(oriName);
            } else {
                minvoice.setmRelefile("无附件");
            }
            String oriName1 = docfile1.getOriginalFilename();
            if (oriName1.length()!=0) {
                String path = request.getServletContext().getRealPath("/upload");
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                docfile1.transferTo(new File(path, oriName1));
                minvoice.setmFile(oriName1);
            } else {
                minvoice.setmFile("无附件");
            }
            iContractServiceImp.mupdate(minvoice);
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("con_mid",minvoice.getMid());
            Contract contract=iContractServiceImp.getOne(queryWrapper);
            contract.setConMmoney(minvoice.getmMoney());
            iContractServiceImp.updateone(contract);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/contract/contracts.html";
    }


}
