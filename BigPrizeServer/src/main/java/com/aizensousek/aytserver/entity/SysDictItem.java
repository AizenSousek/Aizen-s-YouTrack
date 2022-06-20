package com.aizensousek.aytserver.entity;

import java.io.Serializable;

/**
 * (SysDictItem)实体类
 *
 * @author makejava
 * @since 2022-06-01 16:27:53
 */
@SuppressWarnings("unused")
public class SysDictItem implements Serializable {
    private static final long serialVersionUID = 463732812151358422L;

    private String dictKey;

    private String keyId;

    private String label;

    private String sortNum;

    private String intro;

    private Integer revision;


    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

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

    public String getSortNum() {
        return sortNum;
    }

    public void setSortNum(String sortNum) {
        this.sortNum = sortNum;
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