package com.huayu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户部门表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("user_department")
public class UserDepartment extends Model<UserDepartment> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "udid", type = IdType.AUTO)
    private Integer udid;

    /**
     * 用户部门
     */
    private String udname;

    public Integer getUdid() {
        return udid;
    }

    public void setUdid(Integer udid) {
        this.udid = udid;
    }
    public String getUdname() {
        return udname;
    }

    public void setUdname(String udname) {
        this.udname = udname;
    }

    @Override
    protected Serializable pkVal() {
        return this.udid;
    }

    @Override
    public String toString() {
        return "UserDepartment{" +
                "udid=" + udid +
                ", udname='" + udname + '\'' +
                '}';
    }
}
