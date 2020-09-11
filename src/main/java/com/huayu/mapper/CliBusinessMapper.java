package com.huayu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.bo.FunnelStatisticsBo;
import com.huayu.pojo.CliBusiness;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CliBusinessMapper extends BaseMapper<CliBusiness> {

    //查询行业下的商机数和金额
    @Select("SELECT  cb.clibusname AS typeName ,COUNT(*) COUNT ,SUM(com.com_sum) SUM  FROM commercial com ,cli_business cb WHERE  com.com_busid=cb.clibusid  GROUP BY cb.clibusid")
    List<FunnelStatisticsBo> queryIndustry();
}
