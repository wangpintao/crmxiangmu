package com.huayu.bo;/*
 *@author
 *@date 2020/9/514:41
 *@Description:客户联合
 */

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.huayu.pojo.AfterSale;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Contract;
import com.huayu.pojo.UserClien;


public class ClientBo {

 @TableField(exist = false)
 private UserClien userClien;

 @TableField(exist = false)
 private Commercial commercial;

 @TableField(exist = false)
 private Contract contract;

 @TableField(exist = false)
 private AfterSale afterSale;

/*商机名称
* */
 @TableField("cli_name")
 private String cliName;

 /*预计成交金额
 * */
 @TableField("com_sum")
 private Long comSum;

 /**
  * 合同金额
  */
 @TableField("con_sum")
 private Long conSum;

 /**
  * 服务评分
  */
 @TableField("aft_score")
 private Integer aftScore;

}
