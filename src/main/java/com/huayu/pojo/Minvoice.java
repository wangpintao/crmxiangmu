package com.huayu.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 开票申请表
 * </p>
 *
 * @author Administrator
 * @since 2020-09-11
 */
@TableName("minvoice")
public class Minvoice extends Model<Minvoice> {

    private static final long serialVersionUID = 1L;

    /**
     * 开票id
     */
    @Id
    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    /**
     * 主题
     */
    @TableField("m_theme")
    private String mTheme;

    /**
     * 结束时间
     */
    @TableField("m_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mDate;

    /**
     * 步骤
     */
    @TableField("m_step")
    private String mStep;

    /**
     * 责任人
     */
    @TableField("m_duty")
    private Integer mDuty;

    /**
     * 参与人
     */
    @TableField("m_duty1")
    private Integer mDuty1;

    /**
     * 详细地址
     */
    @TableField("m_address")
    private String mAddress;

    /**
     * 申请人id
     */
    @TableField("m_uid")
    private Integer mUid;

    /**
     * 申请人姓名
     */
    @TableField("m_name")
    private String mName;

    /**
     * 所属部门
     */
    @TableField("m_dname")
    private String mDname;

    /**
     * 申请日期
     */
    @TableField("m_applydate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mApplydate;

    /**
     * 主要技术条款
     */
    @TableField("m_science")
    private String mScience;

    /**
     * 客户id
     */
    @TableField("m_ucid")
    private Integer mUcid;

    /**
     * 客户名称
     */
    @TableField("m_ucname")
    private String mUcname;

    /**
     * 关联合同
     */
    @TableField("m_relefile")
    private String mRelefile;

    /**
     * 开票种类
     */
    @TableField("m_kind")
    private Integer mKind;

    /**
     * 纳税人识别号
     */
    @TableField("m_ratepaying")
    private String mRatepaying;

    /**
     * 开户账号
     */
    @TableField("m_bank")
    private String mBank;

    /**
     * 地址和电话
     */
    @TableField("m_address_phone")
    private String mAddressPhone;

    /**
     * 开票金额
     */
    @TableField("m_money")
    private Long mMoney;

    /**
     * 开票日期
     */
    @TableField("m_invoice_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mInvoiceDate;

    /**
     * 发票号码
     */
    @TableField("m_phone")
    private String mPhone;

    /**
     * 附件
     */
    @TableField("m_file")
    private String mFile;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getmTheme() {
        return mTheme;
    }

    public void setmTheme(String mTheme) {
        this.mTheme = mTheme;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmStep() {
        return mStep;
    }

    public void setmStep(String mStep) {
        this.mStep = mStep;
    }

    public Integer getmDuty() {
        return mDuty;
    }

    public void setmDuty(Integer mDuty) {
        this.mDuty = mDuty;
    }

    public Integer getmDuty1() {
        return mDuty1;
    }

    public void setmDuty1(Integer mDuty1) {
        this.mDuty1 = mDuty1;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public Integer getmUid() {
        return mUid;
    }

    public void setmUid(Integer mUid) {
        this.mUid = mUid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDname() {
        return mDname;
    }

    public void setmDname(String mDname) {
        this.mDname = mDname;
    }

    public Date getmApplydate() {
        return mApplydate;
    }

    public void setmApplydate(Date mApplydate) {
        this.mApplydate = mApplydate;
    }

    public String getmScience() {
        return mScience;
    }

    public void setmScience(String mScience) {
        this.mScience = mScience;
    }

    public Integer getmUcid() {
        return mUcid;
    }

    public void setmUcid(Integer mUcid) {
        this.mUcid = mUcid;
    }

    public String getmUcname() {
        return mUcname;
    }

    public void setmUcname(String mUcname) {
        this.mUcname = mUcname;
    }

    public String getmRelefile() {
        return mRelefile;
    }

    public void setmRelefile(String mRelefile) {
        this.mRelefile = mRelefile;
    }

    public Integer getmKind() {
        return mKind;
    }

    public void setmKind(Integer mKind) {
        this.mKind = mKind;
    }

    public String getmRatepaying() {
        return mRatepaying;
    }

    public void setmRatepaying(String mRatepaying) {
        this.mRatepaying = mRatepaying;
    }

    public String getmBank() {
        return mBank;
    }

    public void setmBank(String mBank) {
        this.mBank = mBank;
    }

    public String getmAddressPhone() {
        return mAddressPhone;
    }

    public void setmAddressPhone(String mAddressPhone) {
        this.mAddressPhone = mAddressPhone;
    }

    public Long getmMoney() {
        return mMoney;
    }

    public void setmMoney(Long mMoney) {
        this.mMoney = mMoney;
    }

    public Date getmInvoiceDate() {
        return mInvoiceDate;
    }

    public void setmInvoiceDate(Date mInvoiceDate) {
        this.mInvoiceDate = mInvoiceDate;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmFile() {
        return mFile;
    }

    public void setmFile(String mFile) {
        this.mFile = mFile;
    }

    @Override
    protected Serializable pkVal() {
        return this.mid;
    }

    @Override
    public String toString() {
        return "Minvoice{" +
                "mid=" + mid +
                ", mTheme='" + mTheme + '\'' +
                ", mDate=" + mDate +
                ", mStep='" + mStep + '\'' +
                ", mDuty=" + mDuty +
                ", mDuty1=" + mDuty1 +
                ", mAddress='" + mAddress + '\'' +
                ", mUid=" + mUid +
                ", mName='" + mName + '\'' +
                ", mDname='" + mDname + '\'' +
                ", mApplydate=" + mApplydate +
                ", mScience='" + mScience + '\'' +
                ", mUcid=" + mUcid +
                ", mUcname='" + mUcname + '\'' +
                ", mRelefile='" + mRelefile + '\'' +
                ", mKind=" + mKind +
                ", mRatepaying='" + mRatepaying + '\'' +
                ", mBank='" + mBank + '\'' +
                ", mAddressPhone='" + mAddressPhone + '\'' +
                ", mMoney=" + mMoney +
                ", mInvoiceDate=" + mInvoiceDate +
                ", mPhone='" + mPhone + '\'' +
                ", mFile='" + mFile + '\'' +
                '}';
    }
}
