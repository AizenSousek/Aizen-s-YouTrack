package com.aizensousek.aytserver.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目自定义字段信息表(ProExtField)实体类
 *
 * @author makejava
 * @since 2022-06-01 16:27:52
 */
@SuppressWarnings("unused")
public class ProExtField implements Serializable {
    private static final long serialVersionUID = 505182765020264270L;
    /**
     * 自定义字段ID
     */
    private String id;
    /**
     * 关联项目ID
     */
    private String proId;
    /**
     * 项目字段名称
     */
    private String proFieldName;
    /**
     * 项目字段类型
     */
    private String proFieldType;
    /**
     * 是否为空值
     */
    private String beEmpty;
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
    /**
     * 默认值
     */
    private String defValue;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProFieldName() {
        return proFieldName;
    }

    public void setProFieldName(String proFieldName) {
        this.proFieldName = proFieldName;
    }

    public String getProFieldType() {
        return proFieldType;
    }

    public void setProFieldType(String proFieldType) {
        this.proFieldType = proFieldType;
    }

    public String getBeEmpty() {
        return beEmpty;
    }

    public void setBeEmpty(String beEmpty) {
        this.beEmpty = beEmpty;
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

    public String getDefValue() {
        return defValue;
    }

    public void setDefValue(String defValue) {
        this.defValue = defValue;
    }

}