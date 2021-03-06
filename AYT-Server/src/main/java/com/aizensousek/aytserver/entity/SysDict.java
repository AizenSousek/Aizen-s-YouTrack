package com.aizensousek.aytserver.entity;

import java.io.Serializable;

/**
 * (SysDict)实体类
 *
 * @author makejava
 * @since 2022-06-01 16:27:53
 */
@SuppressWarnings("unused")
public class SysDict implements Serializable {
    private static final long serialVersionUID = -38309979077602230L;

    private String keyId;

    private String label;

    private String intro;

    private Integer revision;


    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

}