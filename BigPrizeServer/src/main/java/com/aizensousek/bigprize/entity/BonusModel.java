package com.aizensousek.bigprize.entity;

import java.io.Serializable;

/**
 * (BonusModel)实体类
 *
 * @author aizensousek
 * @since 2022-06-20 15:29:59
 */
@SuppressWarnings("unused")
public class BonusModel implements Serializable {
    private static final long serialVersionUID = -42969693665358290L;

    private String id;

    private String name;

    private String remark;


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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}