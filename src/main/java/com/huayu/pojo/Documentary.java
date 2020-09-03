package com.huayu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 跟单表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("documentary")
public class Documentary extends Model<Documentary> {

    private static final long serialVersionUID = 1L;

    /**
     * 跟单id
     */
    @TableId(value = "docid", type = IdType.AUTO)
    private Integer docid;

    /**
     * 跟单主题名字是商机名
     */
    @TableField("theme")
    private String theme;

    /**
     * 跟单日期
     */
    @TableField("doc_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date docDate;

    /**
     * 跟单详情
     */
    @TableField("doc_details")
    private String docDetails;

    /**
     * 跟单附件
     */
    @TableField("doc_file")
    private String docFile;

    /**
     * 商机外键
     */
    @TableField("doc_comid")
    private Integer docComid;

    /**
     * 跟单分类外键
     */
    @TableField("doc_claid")
    private Integer docClaid;

    /**
     * 跟单状态
     */
    @TableField("doc_staid")
    private Integer docStaid;

    /*
    * 用户外键
    * */
    @TableField("doc_user")
    private Integer docuser;

    private User user;

    private DocClassify docClassify;

    @Override
    protected Serializable pkVal() {
        return this.docid;
    }

    public Integer getDocid() {
        return docid;
    }

    public void setDocid(Integer docid) {
        this.docid = docid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocDetails() {
        return docDetails;
    }

    public void setDocDetails(String docDetails) {
        this.docDetails = docDetails;
    }

    public String getDocFile() {
        return docFile;
    }

    public void setDocFile(String docFile) {
        this.docFile = docFile;
    }

    public Integer getDocComid() {
        return docComid;
    }

    public void setDocComid(Integer docComid) {
        this.docComid = docComid;
    }

    public Integer getDocClaid() {
        return docClaid;
    }

    public void setDocClaid(Integer docClaid) {
        this.docClaid = docClaid;
    }

    public Integer getDocStaid() {
        return docStaid;
    }

    public void setDocStaid(Integer docStaid) {
        this.docStaid = docStaid;
    }

    public Integer getDocuser() {
        return docuser;
    }

    public void setDocuser(Integer docuser) {
        this.docuser = docuser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DocClassify getDocClassify() {
        return docClassify;
    }

    public void setDocClassify(DocClassify docClassify) {
        this.docClassify = docClassify;
    }

    @Override
    public String toString() {
        return "Documentary{" +
                "docid=" + docid +
                ", theme='" + theme + '\'' +
                ", docDate=" + docDate +
                ", docDetails='" + docDetails + '\'' +
                ", docFile='" + docFile + '\'' +
                ", docComid=" + docComid +
                ", docClaid=" + docClaid +
                ", docStaid=" + docStaid +
                ", docuser=" + docuser +
                ", user=" + user +
                ", docClassify=" + docClassify +
                '}';
    }
}
