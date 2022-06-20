package com.aizensousek.aytserver.entity;

import java.io.Serializable;

/**
 * 项目基本信息表(SysProject)实体类
 *
 * @author makejava
 * @since 2022-06-01 16:27:53
 */
@SuppressWarnings("unused")
public class SysProject implements Serializable {
    private static final long serialVersionUID = 167807329310481101L;
    /**
     * 项目ID
     */
    private String id;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目前缀ID
     */
    private String prefixId;
    /**
     * 项目所有者ID
     */
    private String ownerId;
    /**
     * 项目显示LOGO
     */
    private String logoUrl;
    /**
     * 是否设置为项目模板
     */
    private String beTemplate;
    /**
     * 项目描述
     */
    private String describle;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefixId() {
        return prefixId;
    }

    public void setPrefixId(String prefixId) {
        this.prefixId = prefixId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getBeTemplate() {
        return beTemplate;
    }

    public void setBeTemplate(String beTemplate) {
        this.beTemplate = beTemplate;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

}