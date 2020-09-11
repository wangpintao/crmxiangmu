package com.huayu.comment;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huayu.pojo.Documentary;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2020/9/1 8:39
 */
public class DocumentarySelectProvider {
    public String queryall(@Param("docu") Documentary documentary){
        StringBuffer buffer=new StringBuffer("select * from documentary where 1=1");
        if(!StringUtils.isEmpty(documentary)){
            if(!StringUtils.isEmpty(documentary.getDocuser())){
                buffer.append(" and doc_user=#{docu.docuser}");
            }
            if(!StringUtils.isEmpty(documentary.getDocid())){
                if(documentary.getDocid()==1){
                    buffer.append(" and doc_Date=#{docu.docDetails}");
                }else if(documentary.getDocid()==2){
                    buffer.append(" and theme like '%${docu.docDetails}%'");
                }
            }
        }
        return buffer.toString();
    }

    public String queryall1(@Param("docu") Documentary documentary){
        StringBuffer buffer=new StringBuffer("select * from documentary where 1=1");
        if(!StringUtils.isEmpty(documentary)){
            if(!StringUtils.isEmpty(documentary.getDocid())){
                if(documentary.getDocid()==1){
                    buffer.append(" and doc_Date=#{docu.docDetails}");
                }else if(documentary.getDocid()==2){
                    buffer.append(" and theme like '%${docu.docDetails}%'");
                }else if(documentary.getDocid()==3){
                    buffer.append(" and doc_user=#{docu.docDetails}");
                }
            }
        }
        return buffer.toString();
    }
}
