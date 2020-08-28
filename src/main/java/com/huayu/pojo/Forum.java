package com.huayu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 帖子表
 * </p>
 *
 * @author Administrator
 * @since 2020-08-28
 */
@TableName("forum")
public class Forum extends Model<Forum> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "forid", type = IdType.AUTO)
    private Integer forid;

    /**
     * 帖子分类（写死）
     */
    @TableField("for_classify")
    private String forClassify;

    /**
     * 帖子标签
     */
    @TableField("for_label")
    private String forLabel;

    /**
     * 帖子主题
     */
    @TableField("for_theme")
    private String forTheme;

    /**
     * 帖子附件
     */
    @TableField("for_file")
    private String forFile;

    /**
     * 帖子点击量
     */
    @TableField("for_click")
    private Integer forClick;

    /**
     * 帖子回复量
     */
    @TableField("for_reply")
    private Integer forReply;

    /**
     * 帖子作者
     */
    @TableField("for_author")
    private String forAuthor;

    /**
     * 所属商机
     */
    @TableField("for_comname")
    private String forComname;


    @Override
    protected Serializable pkVal() {
        return this.forid;
    }

    public Integer getForid() {
        return forid;
    }

    public void setForid(Integer forid) {
        this.forid = forid;
    }

    public String getForClassify() {
        return forClassify;
    }

    public void setForClassify(String forClassify) {
        this.forClassify = forClassify;
    }

    public String getForLabel() {
        return forLabel;
    }

    public void setForLabel(String forLabel) {
        this.forLabel = forLabel;
    }

    public String getForTheme() {
        return forTheme;
    }

    public void setForTheme(String forTheme) {
        this.forTheme = forTheme;
    }

    public String getForFile() {
        return forFile;
    }

    public void setForFile(String forFile) {
        this.forFile = forFile;
    }

    public Integer getForClick() {
        return forClick;
    }

    public void setForClick(Integer forClick) {
        this.forClick = forClick;
    }

    public Integer getForReply() {
        return forReply;
    }

    public void setForReply(Integer forReply) {
        this.forReply = forReply;
    }

    public String getForAuthor() {
        return forAuthor;
    }

    public void setForAuthor(String forAuthor) {
        this.forAuthor = forAuthor;
    }

    public String getForComname() {
        return forComname;
    }

    public void setForComname(String forComname) {
        this.forComname = forComname;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "forid=" + forid +
                ", forClassify='" + forClassify + '\'' +
                ", forLabel='" + forLabel + '\'' +
                ", forTheme='" + forTheme + '\'' +
                ", forFile='" + forFile + '\'' +
                ", forClick=" + forClick +
                ", forReply=" + forReply +
                ", forAuthor='" + forAuthor + '\'' +
                ", forComname='" + forComname + '\'' +
                '}';
    }
}
