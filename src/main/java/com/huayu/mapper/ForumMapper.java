package com.huayu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huayu.comment.DocumentarySelectProvider;
import com.huayu.comment.ForumSelectProvider;
import com.huayu.pojo.Forum;
import com.huayu.pojo.RolePerm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

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
public interface ForumMapper extends BaseMapper<Forum> {
    @Update("update forum set for_classify=#{forClassify} where forid=#{forid}")
    public Integer updateone(Forum forum);

    @Update("update forum set for_click=#{forClick} where forid=#{forid}")
    public Integer updateone1(Forum forum);

    @Update("update forum set for_reply=#{forReply},for_finally=#{forFinally} where forid=#{forid}")
    public Integer updateone2(Forum forum);

    @SelectProvider(type = ForumSelectProvider.class,method ="queryall")
    public List<Forum> queryall(@Param("page") IPage<Forum> page,@Param("fo") Forum forum);
}
