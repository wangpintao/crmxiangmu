package com.huayu.mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huayu.comment.ContractSelectProvider;
import org.apache.ibatis.annotations.*;
import com.huayu.pojo.Contract;
import org.apache.ibatis.annotations.SelectProvider;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
public interface ContractMapper extends BaseMapper<Contract> {
    @Select("select * from contract where serial =#{serial}")
    Contract queryByConId(String serial);


    @SelectProvider(type = ContractSelectProvider.class,method ="queryall")
    public List<Contract> queryall(@Param("page") IPage<Contract> page, @Param("con") Contract contract);

}
