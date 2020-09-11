package com.huayu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.bo.FunnelStatisticsBo;
import com.huayu.pojo.CliSource;
import com.huayu.pojo.Commercial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CliSourceMapper extends BaseMapper<CliSource> {
    @Select("SELECT cs.clsname AS typeName,COUNT(*) AS COUNT,SUM(com.com_sum)AS SUM FROM commercial com ,cli_source cs WHERE com.com_souid = cs.clsid GROUP BY cs.clsid")
    List<FunnelStatisticsBo> querySource();
}
