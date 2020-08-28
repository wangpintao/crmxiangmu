package com.huayu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("permission")
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "perid", type = IdType.AUTO)
    private Integer perid;

    /**
     * url名称
     */
    private String pername;

    /**
     * url
     */
    private String url;

    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }
    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected Serializable pkVal() {
        return this.perid;
    }

    @Override
    public String toString() {
        return "Permission{" +
        "perid=" + perid +
        ", pername=" + pername +
        ", url=" + url +
        "}";
    }
}
