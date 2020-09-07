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

 /**
  * 客户名字
  */
 @TableField("cli_name")
 private String cliName;

/*商机数
* */
 private Integer csum;


 /*预计成交金额
 * */
 @TableField("com_sum")
 private Long comSum;

 /*合同数
 * */
private Integer conCount;

 /**
  * 合同金额
  */
 @TableField("con_sum")
 private Long conSum;

 /*回款额
 * */


 /*售后服务数
 * */
 private Integer aftCount;

 /**
  * 服务评分
  */
 @TableField("aft_score")
 private Integer aftScore;


 public String getCliName() {
  return cliName;
 }

 public void setCliName(String cliName) {
  this.cliName = cliName;
 }

 public Integer getCsum() {
  return csum;
 }

 public void setCsum(Integer csum) {
  this.csum = csum;
 }

 public Long getComSum() {
  return comSum;
 }

 public void setComSum(Long comSum) {
  this.comSum = comSum;
 }

 public Integer getConCount() {
  return conCount;
 }

 public void setConCount(Integer conCount) {
  this.conCount = conCount;
 }

 public Long getConSum() {
  return conSum;
 }

 public void setConSum(Long conSum) {
  this.conSum = conSum;
 }

 public Integer getAftCount() {
  return aftCount;
 }

 public void setAftCount(Integer aftCount) {
  this.aftCount = aftCount;
 }

 public Integer getAftScore() {
  return aftScore;
 }

 public void setAftScore(Integer aftScore) {
  this.aftScore = aftScore;
 }

 @Override
 public String toString() {
  return "ClientBo{" +
   "cliName='" + cliName + '\'' +
   ", csum=" + csum +
   ", comSum=" + comSum +
   ", conCount=" + conCount +
   ", conSum=" + conSum +
   ", aftCount=" + aftCount +
   ", aftScore=" + aftScore +
   '}';
 }
}
