package com.huayu.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.huayu.pojo.Contract;
import com.huayu.pojo.UserClien;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("after_sale")
public class AfterSaleBo {
    @TableField(exist = false)
    private UserClien userClien;
    @TableField(exist = false)
    private Contract contract;
    /**
     * 售后id
     */
    @TableId(value = "aftid", type = IdType.AUTO)
    private Integer aftid;

    /**
     * 售后主题
     */
    @TableField("aft_theme")
    private String aftTheme;

    /**
     * 客户外键
     */
    @TableField("aft_ucid")
    private Integer aftUcid;

    /**
     * 用户外键
     */
    @TableField("aft_uid")
    private Integer aftUid;

    /**
     * 合同外键
     */
    @TableField("aft_conid")
    private String aftConid;

    /**
     * 售后合同详情
     */
    @TableField("aft_details")
    private String aftDetails;

    /**
     * 对方联系人
     */
    @TableField("aft_contacts")
    private String aftContacts;

    /**
     * 固定电话
     */
    @TableField("aft_offphone")
    private Long aftOffphone;

    /**
     * 售后服务类型
     */
    @TableField("aft_genre")
    private String aftGenre;

    /**
     * 售后服务方式
     */
    @TableField("aft_way")
    private String aftWay;

    /**
     * 售后服务开始时间
     */
    @TableField("aft_startdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date aftStartdate;

    /**
     * 售后服务结束时间
     */
    @TableField("aft_enddate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date aftEnddate;

    /**
     * 售后服务类容
     */
    @TableField("aft_class")
    private String aftClass;

    /**
     * 售后客户反馈
     */
    @TableField("aft_feedback")
    private String aftFeedback;

    /**
     * 售后服务人员
     */
    @TableField("aft_crew")
    private String aftCrew;

    /**
     * 服务评分
     */
    @TableField("aft_score")
    private Integer aftScore;

    /**
     * 售后附件
     */
    @TableField("aft_file")
    private String aftFile;

    /**
     * 售后邮箱
     */
    @TableField("aft_qq")
    private String aftqq;

    public UserClien getUserClien() {
        return userClien;
    }

    public void setUserClien(UserClien userClien) {
        this.userClien = userClien;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getAftid() {
        return aftid;
    }

    public void setAftid(Integer aftid) {
        this.aftid = aftid;
    }

    public String getAftTheme() {
        return aftTheme;
    }

    public void setAftTheme(String aftTheme) {
        this.aftTheme = aftTheme;
    }

    public Integer getAftUcid() {
        return aftUcid;
    }

    public void setAftUcid(Integer aftUcid) {
        this.aftUcid = aftUcid;
    }

    public Integer getAftUid() {
        return aftUid;
    }

    public void setAftUid(Integer aftUid) {
        this.aftUid = aftUid;
    }

    public String getAftConid() {
        return aftConid;
    }

    public void setAftConid(String aftConid) {
        this.aftConid = aftConid;
    }

    public String getAftDetails() {
        return aftDetails;
    }

    public void setAftDetails(String aftDetails) {
        this.aftDetails = aftDetails;
    }

    public String getAftContacts() {
        return aftContacts;
    }

    public void setAftContacts(String aftContacts) {
        this.aftContacts = aftContacts;
    }

    public Long getAftOffphone() {
        return aftOffphone;
    }

    public void setAftOffphone(Long aftOffphone) {
        this.aftOffphone = aftOffphone;
    }

    public String getAftGenre() {
        return aftGenre;
    }

    public void setAftGenre(String aftGenre) {
        this.aftGenre = aftGenre;
    }

    public String getAftWay() {
        return aftWay;
    }

    public void setAftWay(String aftWay) {
        this.aftWay = aftWay;
    }

    public Date getAftStartdate() {
        return aftStartdate;
    }

    public void setAftStartdate(Date aftStartdate) {
        this.aftStartdate = aftStartdate;
    }

    public Date getAftEnddate() {
        return aftEnddate;
    }

    public void setAftEnddate(Date aftEnddate) {
        this.aftEnddate = aftEnddate;
    }

    public String getAftClass() {
        return aftClass;
    }

    public void setAftClass(String aftClass) {
        this.aftClass = aftClass;
    }

    public String getAftFeedback() {
        return aftFeedback;
    }

    public void setAftFeedback(String aftFeedback) {
        this.aftFeedback = aftFeedback;
    }

    public String getAftCrew() {
        return aftCrew;
    }

    public void setAftCrew(String aftCrew) {
        this.aftCrew = aftCrew;
    }

    public Integer getAftScore() {
        return aftScore;
    }

    public void setAftScore(Integer aftScore) {
        this.aftScore = aftScore;
    }

    public String getAftFile() {
        return aftFile;
    }

    public void setAftFile(String aftFile) {
        this.aftFile = aftFile;
    }

    public String getAftqq() {
        return aftqq;
    }

    public void setAftqq(String aftqq) {
        this.aftqq = aftqq;
    }

    @Override
    public String toString() {
        return "AfterSaleBo{" +
                "userClien=" + userClien +
                ", contract=" + contract +
                ", aftid=" + aftid +
                ", aftTheme='" + aftTheme + '\'' +
                ", aftUcid=" + aftUcid +
                ", aftUid=" + aftUid +
                ", aftConid='" + aftConid + '\'' +
                ", aftDetails='" + aftDetails + '\'' +
                ", aftContacts='" + aftContacts + '\'' +
                ", aftOffphone=" + aftOffphone +
                ", aftGenre='" + aftGenre + '\'' +
                ", aftWay='" + aftWay + '\'' +
                ", aftStartdate=" + aftStartdate +
                ", aftEnddate=" + aftEnddate +
                ", aftClass='" + aftClass + '\'' +
                ", aftFeedback='" + aftFeedback + '\'' +
                ", aftCrew='" + aftCrew + '\'' +
                ", aftScore=" + aftScore +
                ", aftFile='" + aftFile + '\'' +
                ", aftqq='" + aftqq + '\'' +
                '}';
    }
}
