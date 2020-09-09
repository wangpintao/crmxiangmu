package com.huayu.controller;

import com.huayu.bo.FunnelStatisticsBo;
import com.huayu.bo.StatisticsBo;
import com.huayu.mapper.CommercialMapper;
import com.huayu.pojo.User;
import com.huayu.service.StatisticsBoService;
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
}
