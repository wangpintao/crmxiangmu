package com.huayu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.bo.CommercialBo;
import com.huayu.bo.FunnelStatisticsBo;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.UserClien;
import com.huayu.sqlUtils.ClientSql;
import com.huayu.sqlUtils.salesql;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommercialMapper extends BaseMapper<Commercial> {

 @SelectProvider(type = ClientSql.class,method = "queryCom")
 List<CommercialBo> queryComm();






 @Update("update commercial set coname_cliname=#{conameCliNname},coname=#{coname}, com_sum=#{comSum},com_date=#{comDate} , com_file=#{comFile},com_text=#{comText}, com_depid=#{comDepid},com_uname=#{comUname} , com_participant=#{comParticipant},com_follower=#{comFollower} where coid=#{coid}")
 public boolean updatec(Commercial commercial);

 //本周商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEARWEEK(DATE_FORMAT(com_thisdate,'%Y-%m-%d')) = YEARWEEK(NOW())")
 Integer ComWeek();
 //用户周商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEARWEEK(DATE_FORMAT(com_thisdate,'%Y-%m-%d')) = YEARWEEK(NOW()) AND com_uid=#{comuid}")
 Integer UserComWeek(Integer comuid);

//上周商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEARWEEK(DATE_FORMAT(com_thisdate,'%Y-%m-%d')) = YEARWEEK(NOW())-1")
 Integer ComLaerWeek();
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEARWEEK(DATE_FORMAT(com_thisdate,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND com_uid=#{comuid}")
 Integer UserComLaerWeek(Integer comuid);

 //本月商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE DATE_FORMAT( com_thisdate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
 Integer ComMonth();
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE DATE_FORMAT( com_thisdate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) AND com_uid=#{comuid}")
 Integer UserComMonth(Integer comuid);

 //上月商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( com_thisdate, '%Y%m' ) ) =1")
 Integer ComLaerMonth();
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( com_thisdate, '%Y%m' ) ) =1 AND com_uid=#{comuid}")
 Integer UserComLaerMonth(Integer comuid);

 //本季商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE QUARTER(com_thisdate)=QUARTER(NOW())")
 Integer ComSeason();
 //用户本季商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE QUARTER(com_thisdate)=QUARTER(NOW()) AND com_uid=#{comuid}")
 Integer UserComSeason(Integer comuid);

 //上季商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE QUARTER(com_thisdate)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))")
 Integer ComLaerSeason();
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE QUARTER(com_thisdate)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER)) AND com_uid=#{comuid}")
 Integer UserComLaerSeason(Integer comuid);

 //本年商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEAR(com_thisdate)=YEAR(NOW())")
 Integer ComYear();
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEAR(com_thisdate)=YEAR(NOW()) AND com_uid=#{comuid}")
 Integer UserComYear(Integer comuid);

 //去年商机数
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEAR(com_thisdate)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))")
 Integer ComLaerYear();
 @Select("SELECT COUNT(com_thisdate) FROM commercial WHERE YEAR(com_thisdate)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR)) AND com_uid=#{comuid}")
 Integer UserComLaerYear(Integer comuid);

 //漏斗
 @Select("SELECT * FROM (SELECT d.staname typeName ,COUNT(b.coid) COUNT,IFNULL(SUM(b.com_sum),0) SUM FROM doc_status d LEFT JOIN commercial b ON b.com_staid=d.staid GROUP BY b.com_staid) a ORDER BY a.count")
 List<FunnelStatisticsBo> funnel();
 //商机金额总和
/* @Select("SELECT COUNT(*) COUNT,SUM(com_sum) SUM FROM commercial")
 FunnelStatisticsBo funnelCount();*/
//本季
@Select("SELECT * FROM (SELECT d.staname typeName ,COUNT(b.coid) COUNT,IFNULL(SUM(b.com_sum),0) SUM FROM doc_status d LEFT JOIN commercial b ON b.com_staid=d.staid WHERE QUARTER(com_thisdate)=QUARTER(NOW()) GROUP BY b.com_staid) a ORDER BY a.count")
List<FunnelStatisticsBo> funnelSeason();
//上季
@Select("SELECT * FROM (SELECT d.staname typeName ,COUNT(b.coid) COUNT,IFNULL(SUM(b.com_sum),0) SUM FROM doc_status d LEFT JOIN commercial b ON b.com_staid=d.staid  WHERE QUARTER(com_thisdate)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER)) GROUP BY b.com_staid) a ORDER BY a.count")
List<FunnelStatisticsBo> funnelLaerSeason();
//本年
 @Select("SELECT * FROM (SELECT d.staname typeName ,COUNT(b.coid) COUNT,IFNULL(SUM(b.com_sum),0) SUM FROM doc_status d LEFT JOIN commercial b ON b.com_staid=d.staid WHERE YEAR(com_thisdate)=YEAR(NOW()) GROUP BY b.com_staid) a ORDER BY a.count")
 List<FunnelStatisticsBo> funnelYear();
 //上年
 @Select("SELECT * FROM (SELECT d.staname typeName ,COUNT(b.coid) COUNT,IFNULL(SUM(b.com_sum),0) SUM FROM doc_status d LEFT JOIN commercial b ON b.com_staid=d.staid WHERE YEAR(com_thisdate)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR)) GROUP BY b.com_staid) a ORDER BY a.count")
 List<FunnelStatisticsBo> funnelLaerYar();






}
