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
 * 收入登记表
 * </p>
 *
 * @author Administrator
 * @since 2020-09-11
 */
@TableName("register")
public class Register extends Model<Register> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @TableId(value = "rid", type = IdType.AUTO)
    private Integer rid;

    /**
     * 收入日期
     */
    @TableField("r_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rDate;

    /**
     * 收入分类 1利息收入 2 投资收入 3 主营业务收入 4 其他业务收入
     */
    @TableField("r_classify")
    private Integer rClassify;

    /**
     * 收入金额
     */
    @TableField("r_money")
    private Long rMoney;

    /**
     * 收款方式 1 现金 2 银行转账
     */
    @TableField("r_way")
    private Integer rWay;

    /**
     * 用户id
     */
    @TableField("r_uid")
    private Integer rUid;

    /**
     * 关联人员
     */
    @TableField("r_name")
    private String rName;

    /**
     * 关联部门id
     */
    @TableField("r_deptid")
    private Integer rDeptid;

    /**
     * 客户id
     */
    @TableField("r_ucid")
    private Integer rUcid;

    /**
     * 合同id
     */
    @TableField("r_conid")
    private Integer rConid;

    /**
     * 收入说明
     */
    @TableField("r_explain")
    private String rExplain;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public Integer getrClassify() {
        return rClassify;
    }

    public void setrClassify(Integer rClassify) {
        this.rClassify = rClassify;
    }

    public Long getrMoney() {
        return rMoney;
    }

    public void setrMoney(Long rMoney) {
        this.rMoney = rMoney;
    }

    public Integer getrWay() {
        return rWay;
    }

    public void setrWay(Integer rWay) {
        this.rWay = rWay;
    }

    public Integer getrUid() {
        return rUid;
    }

    public void setrUid(Integer rUid) {
        this.rUid = rUid;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public Integer getrDeptid() {
        return rDeptid;
    }

    public void setrDeptid(Integer rDeptid) {
        this.rDeptid = rDeptid;
    }

    public Integer getrUcid() {
        return rUcid;
    }

    public void setrUcid(Integer rUcid) {
        this.rUcid = rUcid;
    }

    public Integer getrConid() {
        return rConid;
    }

    public void setrConid(Integer rConid) {
        this.rConid = rConid;
    }

    public String getrExplain() {
        return rExplain;
    }

    public void setrExplain(String rExplain) {
        this.rExplain = rExplain;
    }

    @Override
    public String toString() {
        return "Register{" +
                "rid=" + rid +
                ", rDate=" + rDate +
                ", rClassify=" + rClassify +
                ", rMoney=" + rMoney +
                ", rWay=" + rWay +
                ", rUid=" + rUid +
                ", rName='" + rName + '\'' +
                ", rDeptid=" + rDeptid +
                ", rUcid=" + rUcid +
                ", rConid=" + rConid +
                ", rExplain='" + rExplain + '\'' +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
