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

    //本周合同机数。
    @Select("SELECT COUNT(con_startdate) FROM contract WHERE YEARWEEK(DATE_FORMAT(con_startdate,'%Y-%m-%d')) = YEARWEEK(NOW())")
    Integer ConWeek();

    //上周合同数
    @Select("SELECT COUNT(con_startdate) FROM contract WHERE YEARWEEK(DATE_FORMAT(con_startdate,'%Y-%m-%d')) = YEARWEEK(NOW())-1")
    Integer ConLaerWeek();

    //本月合同数
    @Select("SELECT COUNT(con_startdate) FROM contract WHERE DATE_FORMAT( con_startdate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
    Integer ConMonth();

    //上月合同数
    @Select("SELECT COUNT(con_startdate) FROM contract WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( con_startdate, '%Y%m' ) ) =1")
    Integer ConLaerMonth();

    //本季合同数
    @Select("SELECT COUNT(con_startdate) FROM contract WHERE QUARTER(con_startdate)=QUARTER(NOW())")
    Integer ConSeason();

    //上季合同数
    @Select("SELECT COUNT(con_startdate) FROM contract WHERE QUARTER(con_startdate)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))")
    Integer ConLaerSeason();

    //本年合同数
    @Select("SELECT COUNT(con_startdate) FROM contract WHERE YEAR(con_startdate)=YEAR(NOW())")
    Integer ConYear();

    //去年合同数
    @Select("SELECT COUNT(con_startdate) FROM contract WHERE YEAR(con_startdate)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))")
    Integer ConLaerYear();

}
