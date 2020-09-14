package com.huayu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huayu.comment.DocumentarySelectProvider;
import com.huayu.pojo.*;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
public interface DocumentaryMapper extends BaseMapper<Documentary> {
    @Results({@Result(column = "doc_user", property = "user",one = @One(select = "userqueryone",fetchType= FetchType.EAGER)),
            @Result(column = "doc_claid", property = "docClassify",one = @One(select = "docClassifyqueryone",fetchType= FetchType.EAGER))})
    @SelectProvider(type = DocumentarySelectProvider.class,method ="queryall")
    public List<Documentary> queryall(@Param("docu") Documentary documentary);

    @Results({@Result(column = "doc_user", property = "user",one = @One(select = "userqueryone",fetchType= FetchType.EAGER)),
            @Result(column = "doc_claid", property = "docClassify",one = @One(select = "docClassifyqueryone",fetchType= FetchType.EAGER))})
    @SelectProvider(type = DocumentarySelectProvider.class,method ="queryall1")
    public List<Documentary> queryall2(@Param("docu") Documentary documentary);

    @Results({@Result(column = "doc_user", property = "user",one = @One(select = "userqueryone",fetchType= FetchType.EAGER)),
            @Result(column = "doc_claid", property = "docClassify",one = @One(select = "docClassifyqueryone",fetchType= FetchType.EAGER))})
    @Select("select * from documentary where doc_comid=#{value}")
    public List<Documentary> queryall1(Integer coid);

    @Select("select * from user where uid=#{value}")
    public User userqueryone(Integer uid);

    @Select("select * from doc_classify where claid=#{value}")
    public DocClassify docClassifyqueryone(Integer claid);

    @Update("update commercial set com_staid=#{comStaid} where coid=#{coid}")
    public int commercialupdate(Commercial commercial);

    //本周跟单机数
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE YEARWEEK(DATE_FORMAT(doc_date,'%Y-%m-%d')) = YEARWEEK(NOW())")
    Integer DocWeek();
    //用户周成交数
    @Select("SELECT COUNT(*) FROM documentary WHERE YEARWEEK(DATE_FORMAT(doc_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1) AND doc_staid =1 AND  doc_user=#{docuid}")
    Integer UserStateDocWeek(Integer docuid);
    @Select("SELECT COUNT(*) FROM documentary WHERE YEARWEEK(DATE_FORMAT(doc_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1) AND doc_staid =1")
    Integer StateDocWeek();
    @Select("SELECT COUNT(*) FROM documentary WHERE YEARWEEK(DATE_FORMAT(doc_date,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1) AND  doc_user=#{docuid}")
    Integer UserDocWeek(Integer docuid);

    //上周跟单数
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE YEARWEEK(DATE_FORMAT(doc_date,'%Y-%m-%d')) = YEARWEEK(NOW())-1")
    Integer DocLaerWeek();
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE YEARWEEK(DATE_FORMAT(doc_date,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND  doc_user=#{docuid}")
    Integer UserDocLaerWeek(Integer docuid);
    //上周用户跟单成交数
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE YEARWEEK(DATE_FORMAT(doc_date,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND  doc_staid =1 AND doc_user=#{docuid}")
    Integer UserStateDocLaerWeek(Integer docuid);
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE YEARWEEK(DATE_FORMAT(doc_date,'%Y-%m-%d')) = YEARWEEK(NOW())-1 AND doc_staid =1")
    Integer StateDocLaerWeek();

    //本月跟单数
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE DATE_FORMAT( doc_date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )")
    Integer DocMonth();
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE DATE_FORMAT( doc_date, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) AND doc_staid =1")
    Integer StateDocMonth();

    //上月跟单数
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( doc_date, '%Y%m' ) ) =1")
    Integer DocLaerMonth();
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE PERIOD_DIFF( DATE_FORMAT( NOW( ) , '%Y%m' ) , DATE_FORMAT( doc_date, '%Y%m' ) ) =1 AND doc_staid =1")
    Integer StateDocLaerMonth();

    //本季跟单数
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE QUARTER(doc_date)=QUARTER(NOW())")
    Integer DocSeason();
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE QUARTER(doc_date)=QUARTER(NOW()) AND doc_staid =1")
    Integer StateDocSeason();

    //上季跟单数
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE QUARTER(doc_date)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))")
    Integer DocLaerSeason();
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE QUARTER(doc_date)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER)) AND doc_staid =1")
    Integer StateDocLaerSeason();

    //本年跟单数
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE YEAR(doc_date)=YEAR(NOW())")
    Integer DocYear();
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE YEAR(doc_date)=YEAR(NOW()) AND doc_staid =1")
    Integer StateDocYear();

    //去年跟单数
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE YEAR(doc_date)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR))")
    Integer DocLaerYear();
    @Select("SELECT COUNT(doc_date) FROM documentary WHERE YEAR(doc_date)=YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR)) AND doc_staid =1")
    Integer StateDocLaerYear();

}
