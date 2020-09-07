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
 * 商机表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("commercial")
public class Commercial extends Model<Commercial> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "coid", type = IdType.AUTO)
    private Integer coid;

    /*
    * 客户商机名称
    * */
    @TableField("coname_cliname")
    private String conameCliNname;

    /**
     * 商机名称
     */
    private String coname;

    /*客户所属行业外键
    * */
    @TableField("com_busid")
    private Integer comBusid;

    /*客户所属行业名称
     * */
    @TableField("com_busname")
    private String comBusname;


    /**
     * 客户来源外键（也就是商机来源）
     */
    @TableField("com_souid")
    private Integer comSouid;

    /*客户来源名称
    * */
    @TableField("com_name")
    private String comName;

    /**
     * 商机状态（取跟单的状态）
     */
    @TableField("com_staid")
    private Integer comStaid;

    /**
     * 客户外键
     */
    @TableField("com_ucid")
    private Integer comUcid;

    /**
     * 跟单外键（暂时没考虑用）
     */
    @TableField("com_docid")
    private Integer comDocid;

    /**
     * 商机成交金额
     */
    @TableField("com_sum")
    private Long comSum;

    /**
     * 商机预计成交日期
     */
    @TableField("com_date")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date comDate;

    /**
     * 商机联系人
     */
    @TableField("com_contacts")
    private String comContacts;

    /**
     * 商机联系人的部门
     */
    @TableField("com_department")
    private String comDepartment;

    /**
     * 商机联系人的职务
     */
    @TableField("com_job")
    private String comJob;

    /**
     * 商机联系人座机
     */
    @TableField("com_offphone")
    private Integer comOffphone;

    /**
     * 商机联系人的移动电话
     */
    @TableField("com_phone")
    private Long comPhone;

    /**
     * 商机联系人邮箱
     */
    @TableField("com_mail")
    private String comMail;

    /**
     * 商机附件
     */
    @TableField("com_file")
    private String comFile;

    /**
     * 商机业务需求
     */
    @TableField("com_text")
    private String comText;

    /**
     * 该商机属于哪个部门
     */
    @TableField("com_depid")
    private String comDepid;

    /**
     * 商机属于哪个用户
     */
    @TableField("com_uname")
    private String comUname;

    /**
     * 商机参与人
     */
    @TableField("com_participant")
    private String comParticipant;

    /**
     * 商机关注人
     */
    @TableField("com_follower")
    private String comFollower;


    @Override
    protected Serializable pkVal() {
        return this.coid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }


    public Integer getComStaid() {
        return comStaid;
    }

    public void setComStaid(Integer comStaid) {
        this.comStaid = comStaid;
    }

    public Integer getComUcid() {
        return comUcid;
    }

    public void setComUcid(Integer comUcid) {
        this.comUcid = comUcid;
    }

    public Integer getComDocid() {
        return comDocid;
    }

    public void setComDocid(Integer comDocid) {
        this.comDocid = comDocid;
    }

    public Long getComSum() {
        return comSum;
    }

    public void setComSum(Long comSum) {
        this.comSum = comSum;
    }

    public Date getComDate() {
        return comDate;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    public String getComContacts() {
        return comContacts;
    }

    public void setComContacts(String comContacts) {
        this.comContacts = comContacts;
    }

    public String getComDepartment() {
        return comDepartment;
    }

    public void setComDepartment(String comDepartment) {
        this.comDepartment = comDepartment;
    }

    public String getComJob() {
        return comJob;
    }

    public void setComJob(String comJob) {
        this.comJob = comJob;
    }

    public Integer getComOffphone() {
        return comOffphone;
    }

    public void setComOffphone(Integer comOffphone) {
        this.comOffphone = comOffphone;
    }

    public Long getComPhone() {
        return comPhone;
    }

    public void setComPhone(Long comPhone) {
        this.comPhone = comPhone;
    }

    public String getComMail() {
        return comMail;
    }

    public void setComMail(String comMail) {
        this.comMail = comMail;
    }

    public String getComFile() {
        return comFile;
    }

    public void setComFile(String comFile) {
        this.comFile = comFile;
    }

    public String getComText() {
        return comText;
    }

    public void setComText(String comText) {
        this.comText = comText;
    }

    public String getComDepid() {
        return comDepid;
    }

    public void setComDepid(String comDepid) {
        this.comDepid = comDepid;
    }

    public String getComUname() {
        return comUname;
    }

    public void setComUname(String comUname) {
        this.comUname = comUname;
    }

    public String getComParticipant() {
        return comParticipant;
    }

    public void setComParticipant(String comParticipant) {
        this.comParticipant = comParticipant;
    }

    public String getComFollower() {
        return comFollower;
    }

    public void setComFollower(String comFollower) {
        this.comFollower = comFollower;
    }

    public String getConameCliNname() {
        return conameCliNname;
    }

    public void setConameCliNname(String conameCliNname) {
        this.conameCliNname = conameCliNname;
    }



    public Integer getComSouid() {
        return comSouid;
    }

    public void setComSouid(Integer comSouid) {
        this.comSouid = comSouid;
    }

    public Integer getComBusid() {
        return comBusid;
    }

    public void setComBusid(Integer comBusid) {
        this.comBusid = comBusid;
    }

    public String getComBusname() {
        return comBusname;
    }

    public void setComBusname(String comBusname) {
        this.comBusname = comBusname;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    @Override
    public String toString() {
        return "Commercial{" +
         "coid=" + coid +
         ", conameCliNname='" + conameCliNname + '\'' +
         ", coname='" + coname + '\'' +
         ", comBusid=" + comBusid +
         ", comBusname='" + comBusname + '\'' +
         ", comSouid=" + comSouid +
         ", comName='" + comName + '\'' +
         ", comStaid=" + comStaid +
         ", comUcid=" + comUcid +
         ", comDocid=" + comDocid +
         ", comSum=" + comSum +
         ", comDate=" + comDate +
         ", comContacts='" + comContacts + '\'' +
         ", comDepartment='" + comDepartment + '\'' +
         ", comJob='" + comJob + '\'' +
         ", comOffphone=" + comOffphone +
         ", comPhone=" + comPhone +
         ", comMail='" + comMail + '\'' +
         ", comFile='" + comFile + '\'' +
         ", comText='" + comText + '\'' +
         ", comDepid='" + comDepid + '\'' +
         ", comUname='" + comUname + '\'' +
         ", comParticipant='" + comParticipant + '\'' +
         ", comFollower='" + comFollower + '\'' +
         '}';
    }
}
