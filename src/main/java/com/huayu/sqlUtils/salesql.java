package com.huayu.sqlUtils;

import com.github.pagehelper.util.StringUtil;
import com.huayu.pojo.AfterSale;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

public class salesql {
    public String select(@Param("afterSale")AfterSale afterSale){
        StringBuffer sql = new StringBuffer("select * from after_Sale where 1=1");
        if (!StringUtils.isEmpty(afterSale)) {
            if (!StringUtil.isEmpty(afterSale.getAftTheme())) {
                sql.append(" and aft_theme like '%" + afterSale.getAftTheme() + "%'");
            }
            if (!StringUtil.isEmpty(afterSale.getAftGenre())) {
                sql.append(" and aft_genre="+afterSale.getAftGenre());
            }
            if (afterSale.getAftStartdate()!=null && "".equals(afterSale.getAftStartdate())) {
                sql.append(" and aft_startdate="+afterSale.getAftStartdate());
            }
        }
        return sql.toString();
    }





}
