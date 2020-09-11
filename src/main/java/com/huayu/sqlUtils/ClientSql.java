package com.huayu.sqlUtils;

import com.github.pagehelper.util.StringUtil;
import com.huayu.pojo.AfterSale;
import com.huayu.pojo.Commercial;
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


    public String queryCom(@Param("commercial") Commercial commercial){
        StringBuffer sql = new StringBuffer("select c.com_ucid,c.coid, c.coname_cliname as conname ,d.staname,c.com_sum,c.com_uname,max(y.doc_date) as docDates from commercial c ,doc_status d ,documentary y where c.com_staid=d.staid and c.coid=y.doc_comid  ");
       if(null!=commercial){//查询
           if(!StringUtils.isEmpty(commercial.getConameCliNname())){
               sql.append(" and c.coname_cliname like '%" + commercial.getConameCliNname() + "%'");
           }
           if(null!=commercial.getComStaid() && commercial.getComStaid()!=0 ){
               sql.append(" and d.staid = "+ commercial.getComStaid() + "");
           }
           if(!StringUtils.isEmpty(commercial.getComUname())){
               sql.append(" and c.com_uname like '%" + commercial.getComUname() + "%'");
           }
           if(!StringUtils.isEmpty(commercial.getComDepid())){
               sql.append(" and c.com_depid like '%" + commercial.getComDepid() + "%'");
           }
           if(!StringUtils.isEmpty(commercial.getComSum())){
               sql.append(" and c.com_sum like '%" + commercial.getComSum() + "%'");
           }
           if(!StringUtils.isEmpty(commercial.getConame())){
               sql.append(" and c.com_date =#{commercial.coname} ");
           }

           sql.append(" GROUP BY  conname ");
       }else{
           sql.append(" GROUP BY  conname ");
       }

        return sql.toString();
    }


    public String querybo(@Param("comUcid") Integer comUcid,@Param("commercial")Commercial commercial){
        StringBuffer sql = new StringBuffer("select c.com_ucid,c.coid, c.coname_cliname as conname ,d.staname,c.com_sum,c.com_uname,y.doc_date as docDates from commercial c left join doc_status d on c.com_staid=d.staid  left join documentary y  on c.coid=y.doc_comid  where c.com_ucid= #{comUcid}");
        if(null!=commercial){//查询
            if(!StringUtils.isEmpty(commercial.getConameCliNname())){
                sql.append(" and c.coname_cliname like '%" + commercial.getConameCliNname() + "%'");
            }
            if(null!=commercial.getComStaid() && commercial.getComStaid()!=0 ){
                sql.append(" and d.staid = "+ commercial.getComStaid() + "");
            }
            if(!StringUtils.isEmpty(commercial.getComUname())){
                sql.append(" and c.com_uname like '%" + commercial.getComUname() + "%'");
            }
            if(!StringUtils.isEmpty(commercial.getComDepid())){
                sql.append(" and c.com_depid like '%" + commercial.getComDepid() + "%'");
            }
            if(!StringUtils.isEmpty(commercial.getComSum())){
                sql.append(" and c.com_sum like '%" + commercial.getComSum() + "%'");
            }
            if(!StringUtils.isEmpty(commercial.getConame())){
                sql.append(" and c.com_date =#{commercial.coname} ");
            }


        }
        return sql.toString();
    }






}
