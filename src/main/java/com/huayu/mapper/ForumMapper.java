package com.huayu.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huayu.pojo.Forum;
import com.huayu.pojo.RolePerm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

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
}
