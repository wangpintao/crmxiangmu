package com.huayu.controller;

import com.huayu.bo.AllNumberBo;
import com.huayu.bo.FunnelStatisticsBo;
import com.huayu.bo.StatisticsBo;
import com.huayu.mapper.CommercialMapper;
import com.huayu.pojo.User;
import com.huayu.service.StatisticsBoService;
import com.huayu.service.imp.ICliBusinessServiceImp;
import com.huayu.service.imp.ICliSourceServiceImp;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/statistics/")
public class StatisticsController {

    @Autowired
    private StatisticsBoService statisticsBoService;
    @Autowired
    private ICliBusinessServiceImp iCliBusinessServiceImp;
    @Autowired
    private ICliSourceServiceImp iCliSourceServiceImp;


    @RequestMapping("/querystat.do")
    @ResponseBody
    public Map<String,Integer> querystat(){
        return  statisticsBoService.statistics();
    }

    //查询用户的周 合同，商机，跟单数
    @RequestMapping("/queryByWeek.do")
    @ResponseBody
    public ModelAndView queryByWeek(){
        ModelAndView modelAndView =new ModelAndView();
        User user = new User();
        user.setUid(1);
        user.setUsername("李娜");
        modelAndView.addObject("userAll",statisticsBoService.queryByWeek(user));
        modelAndView.setViewName("/statistics/week.html");
        return modelAndView;
    }


    @RequestMapping("/funnel.do")
    @ResponseBody
    public List<FunnelStatisticsBo> funnel(){
        return statisticsBoService.funnel();
    }
    @RequestMapping("/funnelSeason.do")
    @ResponseBody
    public List<FunnelStatisticsBo> funnelSeason(){
        return statisticsBoService.funnelSeason();
    }
    @RequestMapping("/funnelLaerSeason.do")
    @ResponseBody
    public List<FunnelStatisticsBo> funnelLaerSeason(){
        return statisticsBoService.funnelLaerSeason();
    }

    @RequestMapping("/funnelYear.do")
    @ResponseBody
    public List<FunnelStatisticsBo> funnelYear(){
        return statisticsBoService.funnelYear();
    }
    @RequestMapping("/funnelLaerYear.do")
    @ResponseBody
    public List<FunnelStatisticsBo> funnelLaerYear(){
        return statisticsBoService.funnelLaerYear();
    }

    @RequestMapping("/queryIndustry.do")
    @ResponseBody
    public  ModelAndView queryIndustry(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("industryList",iCliBusinessServiceImp.queryIndustry());
        modelAndView.setViewName("/statistics/graph.html");
        return modelAndView;
    }
    @RequestMapping("/Industry.do")
    @ResponseBody
    public  List<FunnelStatisticsBo> Industry(){
      return  iCliBusinessServiceImp.queryIndustry();
    }
    @RequestMapping("/querySourceAll.do")
    @ResponseBody
    public  ModelAndView querySourceAll(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("sourceList",iCliSourceServiceImp.querySource());
        modelAndView.setViewName("/statistics/source.html");
        return modelAndView;
    }
    @RequestMapping("/sourceAll.do")
    @ResponseBody
    public  List<FunnelStatisticsBo> sourceAll(){
        return  iCliSourceServiceImp.querySource();
    }
    @RequestMapping("/queryAllSum.do")
    @ResponseBody
    public AllNumberBo queryAllSum(){
        return statisticsBoService.queryAllSum();
    }

    @RequestMapping("/queryStatus.do")
    @ResponseBody
    public List<FunnelStatisticsBo> queryStatus(){
        return statisticsBoService.queryStatus();
    }
}
