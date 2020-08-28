package com.huayu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 角色权限中间表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("role_perm")
public class RolePerm extends Model<RolePerm> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rpid", type = IdType.AUTO)
    private Integer rpid;

    /**
     * 角色id
     */
    private Integer rid;

    /**
     * 权限id
     */
    private Integer perid;

    public Integer getRpid() {
        return rpid;
    }

    public void setRpid(Integer rpid) {
        this.rpid = rpid;
    }
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }

    @Override
    protected Serializable pkVal() {
        return this.rpid;
    }

    @Override
    public String toString() {
        return "RolePerm{" +
        "rpid=" + rpid +
        ", rid=" + rid +
        ", perid=" + perid +
        "}";
    }
}
