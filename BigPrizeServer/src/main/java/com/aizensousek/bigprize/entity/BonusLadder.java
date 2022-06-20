package com.aizensousek.bigprize.entity;

import java.io.Serializable;

/**
 * (BonusLadder)实体类
 *
 * @author aizensousek
 * @since 2022-06-22 11:03:19
 */
@SuppressWarnings("unused")
public class BonusLadder implements Serializable {
    private static final long serialVersionUID = -56380095906298744L;
    
    private String id;
    /**
     * 所属指标ID
     */
    private String indiId;
    /**
     * 指标计算公式
     */
    private String indiCalculateStr;
    /**
     * 最小阶梯
     */
    private Integer minLadder;
    /**
     * 最大阶梯
     */
    private Integer maxLadder;
    /**
     * 满足最大阶梯时的计算公式
     */
    private String maxLadderCalculateStr;
    /**
     * 主要计算数据源
     */
    private String calculateSource;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndiId() {
        return indiId;
    }

    public void setIndiId(String indiId) {
        this.indiId = indiId;
    }

    public String getIndiCalculateStr() {
        return indiCalculateStr;
    }

    public void setIndiCalculateStr(String indiCalculateStr) {
        this.indiCalculateStr = indiCalculateStr;
    }

    public Integer getMinLadder() {
        return minLadder;
    }

    public void setMinLadder(Integer minLadder) {
        this.minLadder = minLadder;
    }

    public Integer getMaxLadder() {
        return maxLadder;
    }

    public void setMaxLadder(Integer maxLadder) {
        this.maxLadder = maxLadder;
    }

    public String getMaxLadderCalculateStr() {
        return maxLadderCalculateStr;
    }

    public void setMaxLadderCalculateStr(String maxLadderCalculateStr) {
        this.maxLadderCalculateStr = maxLadderCalculateStr;
    }

    public String getCalculateSource() {
        return calculateSource;
    }

    public void setCalculateSource(String calculateSource) {
        this.calculateSource = calculateSource;
    }

}