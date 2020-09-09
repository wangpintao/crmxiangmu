package com.huayu.sqlUtils;

import com.github.pagehelper.util.StringUtil;
import com.huayu.pojo.AfterSale;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

public class ClientSql {
    public String select(@Param("clientid")Integer clientid,@Param("keys")String keys){
        StringBuffer sql = new StringBuffer("select * from user_clien where 1=1");
        if(keys=="" || keys==null){
            sql.append("1=1");
        }else if(clientid==1 && clientid!=0){
            sql.append(" and cli_name like '%" + keys + "%'");
        }else if(clientid==2 && clientid!=0){
            sql.append(" and cli_pinyin like '%" + keys + "%'");
        }else if(clientid==3 && clientid!=0){
            sql.append(" and cli_contacts like '%" + keys + "%'");
        }
        return sql.toString();
    }


    public String queryCom(){
        StringBuffer sql = new StringBuffer("select c.coname_cliname,d.staname,c.com_sum,c.com_uname,y.doc_date from commercial c ,doc_status d ,documentary y where c.com_staid=d.staid and c.coid=y.doc_comid GROUP BY c.coname ,y.doc_date  ORDER BY y.doc_date desc limit 0,1  ");
        return sql.toString();
    }




}
