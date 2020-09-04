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
    public List<Documentary> queryall(@Param("page") IPage<Documentary> page,@Param("docu") Documentary documentary);

    @Results({@Result(column = "doc_user", property = "user",one = @One(select = "userqueryone",fetchType= FetchType.EAGER)),
            @Result(column = "doc_claid", property = "docClassify",one = @One(select = "docClassifyqueryone",fetchType= FetchType.EAGER))})
    @SelectProvider(type = DocumentarySelectProvider.class,method ="queryall1")
    public List<Documentary> queryall2(@Param("page") IPage<Documentary> page,@Param("docu") Documentary documentary);

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


}
