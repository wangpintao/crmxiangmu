package com.huayu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huayu.layuiUtils.Stulayui;
import com.huayu.pojo.*;
import com.huayu.service.imp.*;
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
import java.text.ParseException;
import java.util.Date;
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
    @Autowired
    private IUserClienServiceImp iUserClienServiceImp;
    @Autowired
    private IDocStatusServiceImp iDocStatusServiceImp;
    @Autowired
    private IUserServiceImp iUserServiceImp;

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
            stulayui.setMsg("无数据");
            stulayui.setCount(list.size());
            stulayui.setData(list);
        }
        return stulayui;
    }

    @RequestMapping("/queryall1.do")
    @ResponseBody
    public Stulayui queryall1(Integer page,Integer limit,Documentary documentary){
        Stulayui stulayui=new Stulayui();
        Page<Documentary> page1=new Page<>(page,limit);
        if(documentary.getDocid()!=null){
            if(documentary.getDocid()==3){
                QueryWrapper queryWrapper=new QueryWrapper();
                queryWrapper.eq("uname",documentary.getDocDetails());
                User user=iUserServiceImp.getOne(queryWrapper);
                if(user!=null){
                    documentary.setDocDetails(String.valueOf(user.getUid()));
                }
            }
        }
        List<Documentary> list=iDocumentaryServiceImp.queryall2(page1,documentary);
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
        //跟单分类
        List<DocClassify> list1=iDocClassifyServiceImp.list();
        model.addAttribute("shang",list);
        model.addAttribute("gen",list1);
        return "/documentary/add";
    }

    @RequestMapping("/adds.do")
    public String adds(Model model){
        //商机主题
        List<Commercial> list=iCommercialServiceImp.list();
        //跟单分类
        List<DocClassify> list1=iDocClassifyServiceImp.list();
        model.addAttribute("shang",list);
        model.addAttribute("gen",list1);
        return "/documentary/adds";
    }

    @PostMapping("/add1.do")
    public String add1(@RequestParam("file") MultipartFile docfile,Documentary documentary,HttpServletRequest request){
        try {
            if(docfile!=null){
                String oriName = docfile.getOriginalFilename();
                String path = request.getServletContext().getRealPath("/upload");
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                docfile.transferTo(new File(path, oriName));
                documentary.setDocFile(oriName);
            }else{
                documentary.setDocFile("无附件");
            }
            DocClassify docClassify=iDocClassifyServiceImp.getById(documentary.getDocClaid());
            documentary.setTheme(documentary.getTheme()+docClassify.getClaname());
            documentary.setDocDate(new Date());
            documentary.setDocStaid(4);
            iDocumentaryServiceImp.save(documentary);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/documentary/documentary.html";
    }

    @PostMapping("/add1s.do")
    public String add1s(@RequestParam("file") MultipartFile docfile,Documentary documentary,HttpServletRequest request){
        try {
            if(docfile!=null){
                String oriName = docfile.getOriginalFilename();
                String path = request.getServletContext().getRealPath("/upload");
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                docfile.transferTo(new File(path, oriName));
                documentary.setDocFile(oriName);
            }else{
                documentary.setDocFile("无附件");
            }
            DocClassify docClassify=iDocClassifyServiceImp.getById(documentary.getDocClaid());
            documentary.setTheme(documentary.getTheme()+docClassify.getClaname());
            documentary.setDocDate(new Date());
            documentary.setDocStaid(4);
            iDocumentaryServiceImp.save(documentary);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/documentary/documentarys.html";
    }

    @PostMapping("/coname.do")
    @ResponseBody
    public Stulayui coname(Integer coid){
        Stulayui stulayui=new Stulayui();
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("coid",coid);
        Commercial commercial=iCommercialServiceImp.getOne(queryWrapper);
        if(commercial!=null){
            stulayui.setMsg(commercial.getConame());
        }
        return stulayui;
    }

    @PostMapping("/cdocumentary.do")
    @ResponseBody
    public Stulayui cdocu(Integer coid){
        Stulayui stulayui=new Stulayui();
        List<Documentary> list=iDocumentaryServiceImp.queryall1(coid);
        if(list.size()>0){
            stulayui.setCode(0);
            stulayui.setData(list);
        }else{
            stulayui.setCode(1);
            stulayui.setMsg("无跟单记录");
        }
        return stulayui;
    }

    @RequestMapping("/update.do")
    public String update(Documentary documentary,Model model) throws ParseException {
        QueryWrapper queryWrapper1=new QueryWrapper();
        queryWrapper1.eq("coid",documentary.getDocComid());
        Commercial commercial=iCommercialServiceImp.getOne(queryWrapper1);
        QueryWrapper queryWrapper2=new QueryWrapper();
        queryWrapper2.eq("ucid",commercial.getComUcid());
        UserClien userClien=iUserClienServiceImp.getOne(queryWrapper2);
        List<DocStatus> list=iDocStatusServiceImp.list();
        model.addAttribute("comm",commercial);
        model.addAttribute("user",userClien);
        model.addAttribute("sta",list);
        return "/documentary/update.html";
    }

    @RequestMapping("/updates.do")
    public String updates(Documentary documentary,Model model) throws ParseException {
        QueryWrapper queryWrapper1=new QueryWrapper();
        queryWrapper1.eq("coid",documentary.getDocComid());
        Commercial commercial=iCommercialServiceImp.getOne(queryWrapper1);
        QueryWrapper queryWrapper2=new QueryWrapper();
        queryWrapper2.eq("ucid",commercial.getComUcid());
        UserClien userClien=iUserClienServiceImp.getOne(queryWrapper2);
        List<DocStatus> list=iDocStatusServiceImp.list();
        model.addAttribute("comm",commercial);
        model.addAttribute("user",userClien);
        model.addAttribute("sta",list);
        return "/documentary/updates.html";
    }

    @PostMapping("/update1.do")
    public String update1(Commercial commercial){
        iDocumentaryServiceImp.commercialupdate(commercial);
        return "redirect:/documentary/documentary.html";
    }

    @PostMapping("/update1s.do")
    public String update1s(Commercial commercial){
        iDocumentaryServiceImp.commercialupdate(commercial);
        return "redirect:/documentary/documentarys.html";
    }
}
