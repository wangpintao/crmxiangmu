package com.huayu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.huayu.pojo.AfterSale;
import com.huayu.sqlUtils.salesql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface AfterSaleMapper extends BaseMapper<AfterSale> {

    @SelectProvider(type = salesql.class,method = "select")
    List<AfterSale> queryMany(Page page, @Param("afterSale") AfterSale afterSale);
}
