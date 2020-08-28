package com.huayu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("cli_kind")
public class CliKind extends Model<CliKind> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "clikinid", type = IdType.AUTO)
    private Integer clikinid;

    private String clikinname;

    public Integer getClikinid() {
        return clikinid;
    }

    public void setClikinid(Integer clikinid) {
        this.clikinid = clikinid;
    }
    public String getClikinname() {
        return clikinname;
    }

    public void setClikinname(String clikinname) {
        this.clikinname = clikinname;
    }

    @Override
    protected Serializable pkVal() {
        return this.clikinid;
    }

    @Override
    public String toString() {
        return "CliKind{" +
                "clikinid=" + clikinid +
                ", clikinname='" + clikinname + '\'' +
                '}';
    }
}
