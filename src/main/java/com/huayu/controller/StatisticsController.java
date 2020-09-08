package com.huayu.controller;

import com.huayu.bo.StatisticsBo;
import com.huayu.pojo.User;
import com.huayu.service.StatisticsBoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
}
