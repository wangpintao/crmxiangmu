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


    //每周
    @Select("SELECT * FROM after_sale WHERE YEARWEEK(DATE_FORMAT(aft_startdate,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)")
    List<AfterSale> newWeek();

    //上周
    @Select("SELECT * FROM after_sale WHERE YEARWEEK(DATE_FORMAT(aft_startdate,'%Y-%m-%d')) = YEARWEEK(NOW())-1;")
    List<AfterSale> beforeWeek();

    //每月
    @Select("SELECT * FROM after_sale WHERE DATE_FORMAT(aft_startdate,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')")
    List<AfterSale> newMonth();

    //上月
    @Select("SELECT * FROM after_sale WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( aft_startdate, '%Y%m' ) ) =1")
    List<AfterSale> beforeMonth();

    //本季
    @Select("SELECT * FROM after_sale WHERE QUARTER(aft_startdate)=QUARTER(NOW());")
    List<AfterSale> newSeason();

    //上季
    @Select("SELECT * FROM after_sale WHERE QUARTER(aft_startdate)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER));")
    List<AfterSale> beforeSeason();

}
