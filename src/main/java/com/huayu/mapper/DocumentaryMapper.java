package com.huayu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huayu.comment.DocumentarySelectProvider;
import com.huayu.pojo.Documentary;
import com.huayu.pojo.Forum;
import com.huayu.pojo.User;
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
    @Results({@Result(column = "docid", property = "docid"), @Result(column = "theme", property="theme"),
            @Result(column = "doc_date", property = "docDate"), @Result(column = "doc_details", property = "docDetails"),
            @Result(column = "doc_file", property = "docFile"), @Result(column = "doc_comid", property="docComid"),
            @Result(column = "doc_claid", property = "docClaid"), @Result(column = "doc_staid", property="docStaid"),
            @Result(column = "doc_user", property = "docuser"),
            @Result(column = "doc_user", property = "user",one = @One(select = "userqueryone",fetchType= FetchType.EAGER))})
    @SelectProvider(type = DocumentarySelectProvider.class,method ="queryall")
    public List<Documentary> queryall(@Param("page") IPage<Documentary> page,@Param("docu") Documentary documentary);

    @Results({@Result(column ="uid",property ="uid"),@Result(column ="uname",property ="uname"),
            @Result(column ="username",property ="username"),@Result(column ="password",property ="password"),
            @Result(column ="mgae",property ="mgae"),@Result(column ="depid",property ="depid")})
    @Select("select * from user where uid=#{value}")
    public User userqueryone(Integer uid);


}
