package com.aizensousek.aytserver.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目自定义字段数据表(ProFieldItemData)实体类
 *
 * @author makejava
 * @since 2022-06-01 16:27:52
 */
@SuppressWarnings("unused")
public class ProFieldItemData implements Serializable {
    private static final long serialVersionUID = 123738575048201495L;
    /**
     * 数据ID
     */
    private String id;
    /**
     * 关联问题ID
     */
    private String issueId;
    /**
     * 关联的自定义字段ID
     */
    private String proExtFieldId;
    /**
     * 关联的自定义字段类型
     */
    private String proExtFieldType;
    /**
     * 关联的自定义字段的数据值
     */
    private String proExtFieldValue;
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

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getProExtFieldId() {
        return proExtFieldId;
    }

    public void setProExtFieldId(String proExtFieldId) {
        this.proExtFieldId = proExtFieldId;
    }

    public String getProExtFieldType() {
        return proExtFieldType;
    }

    public void setProExtFieldType(String proExtFieldType) {
        this.proExtFieldType = proExtFieldType;
    }

    public String getProExtFieldValue() {
        return proExtFieldValue;
    }

    public void setProExtFieldValue(String proExtFieldValue) {
        this.proExtFieldValue = proExtFieldValue;
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