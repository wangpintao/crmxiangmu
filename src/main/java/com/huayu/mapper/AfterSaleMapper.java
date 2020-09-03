package com.huayu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.huayu.bo.AfterSaleBo;
import com.huayu.pojo.AfterSale;
import com.huayu.sqlUtils.salesql;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AfterSaleMapper extends BaseMapper<AfterSale> {
    //查询所有售后
    @SelectProvider(type = salesql.class,method = "select")
    List<AfterSale> queryMany(Page page, @Param("afterSale") AfterSale afterSale);
    //查询售后明细

    @Results({
            @Result(column = "cli_name",property = "userClien.cliName"),
            @Result(column = "serial",property = "contract.serial"),
            /*@Result(column = "sid",property = "roleList",many=@Many(select = "com.huayu.dao.RoleMappers.querybyid"))*/
    })
    @Select("SELECT * FROM after_sale aft,user_clien uc,contract co WHERE aft.aft_ucid=uc.ucid AND aft.aft_conid = co.serial AND aftid =#{aftid}")
    AfterSaleBo queryAllDetail(Integer aftid);

}
