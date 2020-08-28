package com.huayu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 客户来源表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("cli_source")
public class CliSource extends Model<CliSource> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "clsid", type = IdType.AUTO)
    private Integer clsid;

    private String clsname;

    public Integer getClsid() {
        return clsid;
    }

    public void setClsid(Integer clsid) {
        this.clsid = clsid;
    }
    public String getClsname() {
        return clsname;
    }

    public void setClsname(String clsname) {
        this.clsname = clsname;
    }

    @Override
    protected Serializable pkVal() {
        return this.clsid;
    }

    @Override
    public String toString() {
        return "CliSource{" +
                "clsid=" + clsid +
                ", clsname='" + clsname + '\'' +
                '}';
    }
}
