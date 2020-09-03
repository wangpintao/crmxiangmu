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





}
