package com.huayu.comment;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.huayu.pojo.Contract;
import com.huayu.pojo.Forum;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

/**
 * @author Administrator
 * @version 1.0
 * @description
 * @date 2020/9/1 8:39
 */
public class ContractSelectProvider {
    public String queryall(@Param("con") Contract contract){
        StringBuffer buffer=new StringBuffer("select * from contract where 1=1");
        if(!StringUtils.isEmpty(contract)){
            /*if(!StringUtils.isEmpty(forum.getForForid())){
                buffer.append(" and for_forid=#{fo.forForid}");
            }*/
            if(!StringUtils.isEmpty(contract.getConid())){
                if(contract.getConid()==1){
                    buffer.append(" and conname=#{con.conname}");
                }else if(contract.getConid()==2){
                    buffer.append(" and serial=#{con.conname}");
                }else if(contract.getConid()==3){
                    /*buffer.append(" and for_label=#{con.forClassify}");*/
                }else if(contract.getConid()==4){
                    buffer.append(" and con_uname=#{con.conname}");
                }else if(contract.getConid()==5){
                    buffer.append(" and con_sum=#{con.conname}");
                }else if(contract.getConid()==6){
                    buffer.append(" and con_predate=#{con.conname}");
                }
            }
        }
        return buffer.toString();
    }
}
