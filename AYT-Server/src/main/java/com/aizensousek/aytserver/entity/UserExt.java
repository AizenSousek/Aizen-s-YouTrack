package com.aizensousek.aytserver.entity;

import java.io.Serializable;

/**
 * 用户扩展字段表(UserExt)实体类
 *
 * @author makejava
 * @since 2022-06-01 14:40:20
 */
public class UserExt implements Serializable {
    private static final long serialVersionUID = -72805087172909226L;
    /**
     * 扩展关系ID
     */
    private String id;
    /**
     * 扩展字段显示名称
     */
    private String fieldName;
    /**
     * 扩展字段数据类型
     */
    private String fieldType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

}