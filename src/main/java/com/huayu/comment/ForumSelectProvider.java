package com.huayu.comment;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huayu.pojo.Documentary;
import com.huayu.pojo.Forum;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2020/9/1 8:39
 */
public class ForumSelectProvider {
    public String queryall(@Param("page") IPage<Forum> page,@Param("fo") Forum forum){
        StringBuffer buffer=new StringBuffer("select * from forum where 1=1");
        if(!StringUtils.isEmpty(forum)){
            if(!StringUtils.isEmpty(forum.getForForid())){
                buffer.append(" and for_forid=#{fo.forForid}");
            }
            if(!StringUtils.isEmpty(forum.getForid())){
                if(forum.getForid()==1){
                    buffer.append(" and for_theme=#{fo.forClassify}");
                }else if(forum.getForid()==2){
                    buffer.append(" and for_author=#{fo.forClassify}");
                }else if(forum.getForid()==3){
                    buffer.append(" and for_label=#{fo.forClassify}");
                }else if(forum.getForid()==4){
                    buffer.append(" and for_click=#{fo.forClassify}");
                }else if(forum.getForid()==5){
                    buffer.append(" and for_reply=#{fo.forClassify}");
                }
            }
        }
        return buffer.toString();
    }
}
