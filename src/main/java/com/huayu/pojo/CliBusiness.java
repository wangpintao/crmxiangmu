package com.huayu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 客户所属行业表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("cli_business")
public class CliBusiness extends Model<CliBusiness> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "clibusid", type = IdType.AUTO)
    private Integer clibusid;

    private String clibusname;



    public Integer getClibusid() {
        return clibusid;
    }

    public void setClibusid(Integer clibusid) {
        this.clibusid = clibusid;
    }

    public String getClibusname() {
        return clibusname;
    }

    public void setClibusname(String clibusname) {
        this.clibusname = clibusname;
    }

    @Override
    protected Serializable pkVal() {
        return this.clibusid;
    }

    @Override
    public String toString() {
        return "CliBusiness{" +
                "clibusid=" + clibusid +
                ", clibusname='" + clibusname + '\'' +
                '}';
    }
}
