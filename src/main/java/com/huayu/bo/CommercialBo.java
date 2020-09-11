package com.huayu.bo;/*
 *@author
 *@date 2020/9/514:58
 *@Description:商机联合
 */

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.huayu.pojo.Commercial;
import com.huayu.pojo.Documentary;
import com.huayu.pojo.Forum;
import com.huayu.pojo.UserClien;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CommercialBo {

/* @TableField(exist = false)
 private Commercial commercial;

 @TableField(exist = false)
 private Documentary documentary;

 @TableField(exist = false)
 private Forum forum;*/


 /**
  * 客户外键
  */
 @TableField("com_ucid")
 private Integer comUcid;



 /*商機id
 * */
 private Integer coid;




 /*
  * 客户商机名称
  * */
 private String conname;

 /**
  * 跟单状态 商机状态（取跟单的状态）
  */
 private String staname;

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
 private Date docDates;

/*
* 讨论版
* */

 public Integer getCoid() {
  return coid;
 }

 public void setCoid(Integer coid) {
  this.coid = coid;
 }

 public String getConname() {
  return conname;
 }

 public void setConname(String conname) {
  this.conname = conname;
 }

 public String getStaname() {
  return staname;
 }

 public void setStaname(String staname) {
  this.staname = staname;
 }

 public Long getComSum() {
  return comSum;
 }

 public void setComSum(Long comSum) {
  this.comSum = comSum;
 }

 public String getComUname() {
  return comUname;
 }

 public void setComUname(String comUname) {
  this.comUname = comUname;
 }

 public Date getDocDates() {
  return docDates;
 }

 public void setDocDates(Date docDates) {
  this.docDates = docDates;
 }

 public Integer getComUcid() {
  return comUcid;
 }

 public void setComUcid(Integer comUcid) {
  this.comUcid = comUcid;
 }
}
