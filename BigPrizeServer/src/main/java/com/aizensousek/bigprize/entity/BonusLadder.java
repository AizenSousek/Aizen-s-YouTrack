package com.aizensousek.bigprize.entity;

import java.io.Serializable;

/**
 * (BonusLadder)实体类
 *
 * @author aizensousek
 * @since 2022-06-20 15:29:59
 */
@SuppressWarnings("unused")
public class BonusLadder implements Serializable {
    private static final long serialVersionUID = -23795705005906950L;

    private String id;
    /**
     * 所属指标ID
     */
    private String indiId;
    /**
     * 阶梯计算基线
     */
    private Integer ladderMin;
    /**
     * 阶梯计算上线
     */
    private Integer ladderMax;
    /**
     * 阶梯计算比例
     */
    private Integer ladderCoefficient;


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

    public Integer getLadderMin() {
        return ladderMin;
    }

    public void setLadderMin(Integer ladderMin) {
        this.ladderMin = ladderMin;
    }

    public Integer getLadderMax() {
        return ladderMax;
    }

    public void setLadderMax(Integer ladderMax) {
        this.ladderMax = ladderMax;
    }

    public Integer getLadderCoefficient() {
        return ladderCoefficient;
    }

    public void setLadderCoefficient(Integer ladderCoefficient) {
        this.ladderCoefficient = ladderCoefficient;
    }

}