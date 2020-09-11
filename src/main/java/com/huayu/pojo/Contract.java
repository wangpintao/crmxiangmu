package com.huayu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 合同表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("contract")
public class Contract extends Model<Contract> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "conid", type = IdType.AUTO)
    private Integer conid;

    /**
     * 合同名称
     */
    private String conname;

    /**
     * 合同编号
     */
    private String serial;

    /**
     * 合同金额
     */
    @TableField("con_sum")
    private Long conSum;

    /**
     * 合同开始日期
     */
    @TableField("con_startdate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date conStartdate;

    /**
     * 生效日期
     */
    @TableField("con_predate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date conPredate;

    /**
     * 合同结束日期
     */
    @TableField("con_enddate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date conEnddate;

    /**
     * 对方联系人
     */
    @TableField("con_contacts")
    private String conContacts;

    /**
     * 合同联系人座机
     */
    @TableField("con_offphone")
    private Long conOffphone;

    /**
     * 合同联系人电话
     */
    @TableField("con_phone")
    private Long conPhone;

    /**
     * 合同联系人邮箱
     */
    @TableField("con_mail")
    private String conMail;

    /**
     * 合同技术条款
     */
    private String technical;

    /**
     * 合同商务条款
     */
    private String clause;

    /**
     * 合同附件
     */
    @TableField("con_file")
    private String conFile;

    /**
     * 用户外键
     */
    @TableField("con_uid")
    private Integer conUid;

    /**
     * 客户外键
     */
    @TableField("con_ucid")
    private Integer conUcid;

    /**
     * 跟单外键
     */
    @TableField("con_docid")
    private Integer conDocid;

    /**
     * 关联人员范围是用户（暂时没考虑用）
     */
    @TableField("con_uname")
    private String conUname;

    /**
     * 合同状态
     */
    @TableField("con_state")
    private Integer conState;

    @Override
    protected Serializable pkVal() {
        return this.conid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getConid() {
        return conid;
    }

    public void setConid(Integer conid) {
        this.conid = conid;
    }

    public String getConname() {
        return conname;
    }

    public void setConname(String conname) {
        this.conname = conname;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Long getConSum() {
        return conSum;
    }

    public void setConSum(Long conSum) {
        this.conSum = conSum;
    }

    public Date getConStartdate() {
        return conStartdate;
    }

    public void setConStartdate(Date conStartdate) {
        this.conStartdate = conStartdate;
    }

    public Date getConPredate() {
        return conPredate;
    }

    public void setConPredate(Date conPredate) {
        this.conPredate = conPredate;
    }

    public Date getConEnddate() {
        return conEnddate;
    }

    public void setConEnddate(Date conEnddate) {
        this.conEnddate = conEnddate;
    }

    public String getConContacts() {
        return conContacts;
    }

    public void setConContacts(String conContacts) {
        this.conContacts = conContacts;
    }

    public Long getConOffphone() {
        return conOffphone;
    }

    public void setConOffphone(Long conOffphone) {
        this.conOffphone = conOffphone;
    }

    public Long getConPhone() {
        return conPhone;
    }

    public void setConPhone(Long conPhone) {
        this.conPhone = conPhone;
    }

    public String getConMail() {
        return conMail;
    }

    public void setConMail(String conMail) {
        this.conMail = conMail;
    }

    public String getTechnical() {
        return technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getClause() {
        return clause;
    }

    public void setClause(String clause) {
        this.clause = clause;
    }

    public String getConFile() {
        return conFile;
    }

    public void setConFile(String conFile) {
        this.conFile = conFile;
    }

    public Integer getConUid() {
        return conUid;
    }

    public void setConUid(Integer conUid) {
        this.conUid = conUid;
    }

    public Integer getConUcid() {
        return conUcid;
    }

    public void setConUcid(Integer conUcid) {
        this.conUcid = conUcid;
    }

    public Integer getConDocid() {
        return conDocid;
    }

    public void setConDocid(Integer conDocid) {
        this.conDocid = conDocid;
    }

    public String getConUname() {
        return conUname;
    }

    public void setConUname(String conUname) {
        this.conUname = conUname;
    }

    public Integer getConState() {
        return conState;
    }

    public void setConState(Integer conState) {
        this.conState = conState;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "conid=" + conid +
                ", conname='" + conname + '\'' +
                ", serial='" + serial + '\'' +
                ", conSum=" + conSum +
                ", conStartdate=" + conStartdate +
                ", conPredate=" + conPredate +
                ", conEnddate=" + conEnddate +
                ", conContacts='" + conContacts + '\'' +
                ", conOffphone=" + conOffphone +
                ", conPhone=" + conPhone +
                ", conMail='" + conMail + '\'' +
                ", technical='" + technical + '\'' +
                ", clause='" + clause + '\'' +
                ", conFile='" + conFile + '\'' +
                ", conUid=" + conUid +
                ", conUcid=" + conUcid +
                ", conDocid=" + conDocid +
                ", conUname='" + conUname + '\'' +
                ", conState=" + conState +
                '}';
    }
}
