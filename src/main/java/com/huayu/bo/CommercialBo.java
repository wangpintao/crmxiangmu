package com.huayu.bo;/*
 *@author
 *@date 2020/9/514:58
 *@Description:商机联合
 */

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Documentary;
import com.huayu.pojo.Forum;
import com.huayu.pojo.UserClien;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CommercialBo {

 @TableField(exist = false)
 private Commercial commercial;

 @TableField(exist = false)
 private Documentary documentary;

 @TableField(exist = false)
 private Forum forum;

 /**
  * 商机状态（取跟单的状态）
  */
 @TableField("com_staid")
 private Integer comStaid;

 /**
  * 商机成交金额
  */
 @TableField("com_sum")
 private Long comSum;

 /**
  * 商机属于哪个用户
  */
 @TableField("com_uname")
 private String comUname;

 /**
  * 跟单日期
  */
 @TableField("doc_date")
 @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date docDate;

/*
* 讨论版
* */



}
