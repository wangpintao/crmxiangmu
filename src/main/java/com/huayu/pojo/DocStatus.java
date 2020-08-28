package com.huayu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 跟单状态表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("doc_status")
public class DocStatus extends Model<DocStatus> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "staid", type = IdType.AUTO)
    private Integer staid;

    /**
     * 跟单状态
     */
    private String staname;

    public Integer getStaid() {
        return staid;
    }

    public void setStaid(Integer staid) {
        this.staid = staid;
    }
    public String getStaname() {
        return staname;
    }

    public void setStaname(String staname) {
        this.staname = staname;
    }

    @Override
    protected Serializable pkVal() {
        return this.staid;
    }

    @Override
    public String toString() {
        return "DocStatus{" +
        "staid=" + staid +
        ", staname=" + staname +
        "}";
    }
}
