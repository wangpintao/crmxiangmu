package com.huayu.mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huayu.comment.ContractSelectProvider;
import com.huayu.pojo.AfterSale;
import com.huayu.pojo.Minvoice;
import com.huayu.pojo.Register;
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
    //查询合同
    @Select("SELECT COUNT(*) AS conCount FROM contract")
    Integer ConSum();

    @Update("update contract set conname=#{conname},serial=#{serial},con_sum=#{conSum},con_startdate=#{conStartdate},con_predate=#{conPredate},con_enddate=#{conEnddate},con_contacts=#{conContacts},con_offphone=#{conOffphone},con_phone=#{conPhone},con_mail=#{conMail},technical=#{technical},clause=#{clause},con_file=#{conFile},con_uid=#{conUid},con_ucid=#{conUcid},con_uname=#{conUname},con_rid=#{conRid},con_rmoney=#{conRmoney},con_mid=#{conMid},con_mmoney=#{conMmoney},con_state=#{conState} where conid=#{conid}")
    public Integer updateone(Contract contract);

    //每周
    @Select("SELECT * FROM contract WHERE YEARWEEK(DATE_FORMAT(con_startdate,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)")
    List<Contract> newWeek();

    //上周
    @Select("SELECT * FROM contract WHERE YEARWEEK(DATE_FORMAT(con_startdate,'%Y-%m-%d')) = YEARWEEK(NOW())-1")
    List<Contract> beforeWeek();

    //每月
    @Select("SELECT * FROM contract WHERE DATE_FORMAT(con_startdate,'%Y-%m')=DATE_FORMAT(NOW(),'%Y-%m')")
    List<Contract> newMonth();

    //上月
    @Select("SELECT * FROM contract WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( con_startdate, '%Y%m' ) ) =1")
    List<Contract> beforeMonth();

    //本季
    @Select("SELECT * FROM contract WHERE QUARTER(con_startdate)=QUARTER(NOW())")
    List<Contract> newSeason();

    //上季
    @Select("SELECT * FROM contract WHERE QUARTER(con_startdate)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))")
    List<Contract> beforeSeason();

    //查询最后一条合同
    @Select("SELECT * FROM contract order by conid desc limit 0,1")
    Contract queryone();

    //查询最后一条合同
    @Select("SELECT * FROM register order by conid desc limit 0,1")
    Register rone();

    //查询最后一条合同
    @Select("SELECT * FROM minvoice order by conid desc limit 0,1")
    Minvoice mone();

}
