package com.huayu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 跟单分类表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("docClassify")
public class DocClassify extends Model<DocClassify> {

    private static final long serialVersionUID = 1L;

    /**
     * 跟单主键
     */
    @TableId(value = "claid", type = IdType.AUTO)
    private Integer claid;

    /**
     * 跟单分类名
     */
    private String claname;

    public Integer getClaid() {
        return claid;
    }

    public void setClaid(Integer claid) {
        this.claid = claid;
    }
    public String getClaname() {
        return claname;
    }

    public void setClaname(String claname) {
        this.claname = claname;
    }

    @Override
    protected Serializable pkVal() {
        return this.claid;
    }

    @Override
    public String toString() {
        return "DocClassify{" +
                "claid=" + claid +
                ", claname='" + claname + '\'' +
                '}';
    }
}
