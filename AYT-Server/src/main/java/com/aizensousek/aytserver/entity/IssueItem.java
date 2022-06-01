package com.aizensousek.aytserver.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题信息表(IssueItem)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:37:57
 */
public class IssueItem implements Serializable {
    private static final long serialVersionUID = -35470572582316604L;
    /**
     * 问题ID
     */
    private String id;
    /**
     * 与项目ID关联生成的编码
     */
    private String prefixId;
    /**
     * 关联项目ID
     */
    private String proId;
    /**
     * 问题标题
     */
    private String title;
    /**
     * 问题描述
     */
    private String descContent;
    /**
     * 链接的问题ID
     */
    private String linkId;
    /**
     * 链接的类型
     */
    private String linkType;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updatedBy;
    /**
     * 更新时间
     */
    private Date updatedTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrefixId() {
        return prefixId;
    }

    public void setPrefixId(String prefixId) {
        this.prefixId = prefixId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescContent() {
        return descContent;
    }

    public void setDescContent(String descContent) {
        this.descContent = descContent;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}