package com.huayu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.bo.FunnelStatisticsBo;
import com.huayu.pojo.DocStatus;
import com.huayu.pojo.Documentary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@Mapper
public interface DocStatusMapper extends BaseMapper<DocStatus> {
    //查询状态下的商机数和金额
    @Select("SELECT doc.staname AS typeName , COUNT(*) AS COUNT ,IFNULL(SUM(com.com_sum),0) AS SUM FROM commercial com LEFT JOIN  doc_status doc ON com.com_staid = doc.staid GROUP BY doc.staid")
    List<FunnelStatisticsBo> queryStatus();

}
