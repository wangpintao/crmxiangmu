package com.huayu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.pojo.Contract;
import com.huayu.pojo.DocStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

}
