package com.huayu.service;

import com.huayu.bo.FunnelStatisticsBo;
import com.huayu.bo.StatisticsBo;
import com.huayu.mapper.CommercialMapper;
import com.huayu.mapper.ContractMapper;
import com.huayu.mapper.DocumentaryMapper;
import com.huayu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsBoService {
    @Autowired
    private CommercialMapper commercialMapper;
    @Autowired
    private DocumentaryMapper documentaryMapper;
    @Autowired
    private ContractMapper contractMapper;

    public Map<String,Integer> statistics() {
        Map<String, Integer> map = new HashMap<>();
        //cominess 商机数
        map.put("com_week", commercialMapper.ComWeek());
        map.put("com_last_week", commercialMapper.ComLaerWeek());
        map.put("com_month", commercialMapper.ComMonth());
        map.put("com_last_month", commercialMapper.ComLaerMonth());
        map.put("com_quarter", commercialMapper.ComSeason());
        map.put("com_last_quarter", commercialMapper.ComLaerSeason());
        map.put("com_year", commercialMapper.ComYear());
        map.put("com_last_year", commercialMapper.ComLaerYear());
        //contract 合同数
        map.put("con_week", contractMapper.ConWeek());
        map.put("con_last_week", contractMapper.ConLaerWeek());
        map.put("con_month", contractMapper.ConMonth());
        map.put("con_last_month", contractMapper.ConLaerMonth());
        map.put("con_quarter", contractMapper.ConSeason());
        map.put("con_last_quarter", contractMapper.ConLaerSeason());
        map.put("con_year", contractMapper.ConYear());
        map.put("con_last_year", contractMapper.ConLaerYear());
        //documentary 跟单数
        map.put("doc_week", documentaryMapper.DocWeek());
        map.put("doc_last_week", documentaryMapper.DocLaerWeek());
        map.put("doc_month", documentaryMapper.DocMonth());
        map.put("doc_last_month", documentaryMapper.DocLaerMonth());
        map.put("doc_quarter", documentaryMapper.DocSeason());
        map.put("doc_last_quarter", documentaryMapper.DocLaerSeason());
        map.put("doc_year", documentaryMapper.DocYear());
        map.put("doc_last_year", documentaryMapper.DocLaerYear());
        //成交数
        map.put("state_week", documentaryMapper.StateDocWeek());
        map.put("state_last_week", documentaryMapper.StateDocLaerWeek());
        map.put("state_month", documentaryMapper.StateDocMonth());
        map.put("state_last_month", documentaryMapper.StateDocLaerMonth());
        map.put("state_quarter", documentaryMapper.StateDocSeason());
        map.put("state_last_quarter", documentaryMapper.StateDocLaerSeason());
        map.put("state_year", documentaryMapper.StateDocYear());
        map.put("state_last_year", documentaryMapper.StateDocLaerYear());
        return map;
    }

    //根据用户名查询周商机数和跟单合同数
    public StatisticsBo queryByWeek(User user){
        StatisticsBo statisticsBo =new StatisticsBo();
        //拿到用户名称给bo
        statisticsBo.setUsername(user.getUsername());
        //拿到用户id给bo
        Integer uid = user.getUid();
        statisticsBo.setCom_count(commercialMapper.UserComWeek(uid));
        statisticsBo.setCom_last_coutn(commercialMapper.UserComLaerWeek(uid));
        return statisticsBo;
    }

    /**
     * 所有商机
     */
    public List<FunnelStatisticsBo> funnel(){
        List<FunnelStatisticsBo> list=commercialMapper.funnel();
        FunnelStatisticsBo bo=commercialMapper.funnelCount();
        bo.setTypeName("所有商机");
        return list;
    }
}
