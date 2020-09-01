package com.huayu.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("user_clien")
public class UserClien extends Model<UserClien> implements  Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "ucid", type = IdType.AUTO)
    private Integer ucid;

    /**
     * 客户名字
     */
    @TableField("cli_name")
    private String cliName;

    /**
     * 客户拼音
     */
    @TableField("cli_pinyin")
    private String cliPinyin;

    /**
     * 客户表来源外键
     */
    @TableField("souid")
    private Integer souid;

    /**
     * 客户所属行业外键
     */
    @TableField("busid")
    private Integer busid;

    /**
     * 客户种类外键
     */
    @TableField("kinid")
    private Integer kinid;

    /**
     * 客户网址
     */
    @TableField("curl")
    private String curl;

    /**
     * 国家
     */
    @TableField("cstate")
    private String cstate;

    /**
     * 所属城市
     */
    @TableField("city")
    private String city;

    /**
     * 详细地址
     */
    @TableField("csite")
    private String csite;




    /**
     * 客户邮政编码
     */
    @TableField("cli_mail")
    private String cliMail;

    /**
     * 客户传真
     */
    @TableField("cli_fax")
    private Integer cliFax;

    /**
     * 客户联系人
     */
    @TableField("cli_contacts")
    private String cliContacts;

    /**
     * 客户联系人所在部门
     */
    @TableField("cli_department")
    private String cliDepartment;

    /**
     * 客户联系人职务
     */
    @TableField("cli_job")
    private String cliJob;

    /**
     * 客户办公电话
     */
    @TableField("cli_offphone")
    private Integer cliOffphone;

    /**
     * 客户qq
     */
    @TableField("cli_qq")
    private String cliqq;

    /**
     * 客户电话
     */
    @TableField("cli_phone")
    private Long cliPhone;

    /**
     * 客户法人代表
     */
    @TableField("cli_legalperson")
    private String cliLegalperson;

    /**
     * 客户注册金额
     */
    @TableField("cli_amount")
    private Integer cliAmount;

    /**
     * 客户附加说明
     */
    @TableField("cli_text")
    private String cliText;

    private String clibusname;






    @Override
    protected Serializable pkVal() {
        return this.ucid;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }

    public Integer getUcid() {
        return ucid;
    }

    public void setUcid(Integer ucid) {
        this.ucid = ucid;
    }

    public String getCliName() {
        return cliName;
    }

    public void setCliName(String cliName) {
        this.cliName = cliName;
    }

    public String getCliPinyin() {
        return cliPinyin;
    }

    public void setCliPinyin(String cliPinyin) {
        this.cliPinyin = cliPinyin;
    }

    public Integer getSouid() {
        return souid;
    }

    public void setSouid(Integer souid) {
        this.souid = souid;
    }

    public Integer getBusid() {
        return busid;
    }

    public void setBusid(Integer busid) {
        this.busid = busid;
    }

    public Integer getKinid() {
        return kinid;
    }

    public void setKinid(Integer kinid) {
        this.kinid = kinid;
    }

    public String getCliMail() {
        return cliMail;
    }

    public void setCliMail(String cliMail) {
        this.cliMail = cliMail;
    }

    public Integer getCliFax() {
        return cliFax;
    }

    public void setCliFax(Integer cliFax) {
        this.cliFax = cliFax;
    }

    public String getCliContacts() {
        return cliContacts;
    }

    public void setCliContacts(String cliContacts) {
        this.cliContacts = cliContacts;
    }

    public String getCliDepartment() {
        return cliDepartment;
    }

    public void setCliDepartment(String cliDepartment) {
        this.cliDepartment = cliDepartment;
    }

    public String getCliJob() {
        return cliJob;
    }

    public void setCliJob(String cliJob) {
        this.cliJob = cliJob;
    }

    public Integer getCliOffphone() {
        return cliOffphone;
    }

    public void setCliOffphone(Integer cliOffphone) {
        this.cliOffphone = cliOffphone;
    }

    public String getCliqq() {
        return cliqq;
    }

    public void setCliqq(String cliqq) {
        this.cliqq = cliqq;
    }

    public Long getCliPhone() {
        return cliPhone;
    }

    public void setCliPhone(Long cliPhone) {
        this.cliPhone = cliPhone;
    }

    public String getCliLegalperson() {
        return cliLegalperson;
    }

    public void setCliLegalperson(String cliLegalperson) {
        this.cliLegalperson = cliLegalperson;
    }

    public Integer getCliAmount() {
        return cliAmount;
    }

    public void setCliAmount(Integer cliAmount) {
        this.cliAmount = cliAmount;
    }

    public String getCliText() {
        return cliText;
    }

    public void setCliText(String cliText) {
        this.cliText = cliText;
    }

    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCsite() {
        return csite;
    }

    public void setCsite(String csite) {
        this.csite = csite;
    }

    @Override
    public String toString() {
        return "UserClien{" +
         "ucid=" + ucid +
         ", cliName='" + cliName + '\'' +
         ", cliPinyin='" + cliPinyin + '\'' +
         ", souid=" + souid +
         ", busid=" + busid +
         ", kinid=" + kinid +
         ", curl='" + curl + '\'' +
         ", cstate='" + cstate + '\'' +
         ", city='" + city + '\'' +
         ", csite='" + csite + '\'' +
         ", cliMail='" + cliMail + '\'' +
         ", cliFax=" + cliFax +
         ", cliContacts='" + cliContacts + '\'' +
         ", cliDepartment='" + cliDepartment + '\'' +
         ", cliJob='" + cliJob + '\'' +
         ", cliOffphone=" + cliOffphone +
         ", cliqq='" + cliqq + '\'' +
         ", cliPhone=" + cliPhone +
         ", cliLegalperson='" + cliLegalperson + '\'' +
         ", cliAmount=" + cliAmount +
         ", cliText='" + cliText + '\'' +
         '}';
    }
}
