package com.huayu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.UserClien;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommercialMapper extends BaseMapper<Commercial> {

 @Update("update commercial set coname_cliname=#{conameCliNname},coname=#{coname}, com_sum=#{comSum},com_date=#{comDate} , com_file=#{comFile},com_text=#{comText}, com_depid=#{comDepid},com_uname=#{comUname} , com_participant=#{comParticipant},com_follower=#{comFollower} where coid=#{coid}")
 public boolean updatec(Commercial commercial);

 //本周商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEARWEEK(DATE_FORMAT(com_thisdate,'%Y-%m-%d')) = YEARWEEK(NOW())")
 Integer ComWeek();

//上周商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEARWEEK(DATE_FORMAT(com_thisdate,'%Y-%m-%d')) = YEARWEEK(NOW())-1")
 Integer ComLaerWeek();

 //本月商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE DATE_FORMAT( com_thisdate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
 Integer ComMonth();

 //上月商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( com_thisdate, '%Y%m' ) ) =1")
 Integer ComLaerMonth();

 //本季商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE QUARTER(com_thisdate)=QUARTER(NOW())")
 Integer ComSeason();

 //上季商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE QUARTER(com_thisdate)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))")
 Integer ComLaerSeason();

 //本年商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEAR(com_thisdate)=YEAR(NOW())")
 Integer ComYear();

 //去年商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEAR(com_thisdate)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))")
 Integer ComLaerYear();





}
