package com.aizensousek.bigprize.entity;

import java.io.Serializable;

/**
 * (BonusCalculateIndicator)实体类
 *
 * @author aizensousek
 * @since 2022-06-20 15:29:58
 */
@SuppressWarnings("unused")
public class BonusCalculateIndicator implements Serializable {
    private static final long serialVersionUID = 244636774503850172L;

    private String id;
    /**
     * 指标名称
     */
    private String indiName;
    /**
     * 指标描述
     */
    private String indiComment;
    /**
     * 指标计算类型
     */
    private String indiType;
    /**
     * 阶梯算法ID（如果有）
     */
    private String indiLadderId;
    /**
     * 是否是超额计算
     */
    private String indiIsExcess;
    /**
     * 计算比例
     */
    private Integer indiCoefficient;
    /**
     * 超额类型(百分比还是绝对值）
     */
    private String indiExcessType;
    /**
     * 超额计算基线（百分比或者是绝对值)
     */
    private Integer indiExcessBase;
    /**
     * 指标计算公式（以空格分隔)
     */
    private String indiCalculateStr;
    /**
     * 指标计算条件（以空格进行分隔)
     */
    private String indiIf;
    /**
     * 所属模型ID
     */
    private String modelId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndiName() {
        return indiName;
    }

    public void setIndiName(String indiName) {
        this.indiName = indiName;
    }

    public String getIndiComment() {
        return indiComment;
    }

    public void setIndiComment(String indiComment) {
        this.indiComment = indiComment;
    }

    public String getIndiType() {
        return indiType;
    }

    public void setIndiType(String indiType) {
        this.indiType = indiType;
    }

    public String getIndiLadderId() {
        return indiLadderId;
    }

    public void setIndiLadderId(String indiLadderId) {
        this.indiLadderId = indiLadderId;
    }

    public String getIndiIsExcess() {
        return indiIsExcess;
    }

    public void setIndiIsExcess(String indiIsExcess) {
        this.indiIsExcess = indiIsExcess;
    }

    public Integer getIndiCoefficient() {
        return indiCoefficient;
    }

    public void setIndiCoefficient(Integer indiCoefficient) {
        this.indiCoefficient = indiCoefficient;
    }

    public String getIndiExcessType() {
        return indiExcessType;
    }

    public void setIndiExcessType(String indiExcessType) {
        this.indiExcessType = indiExcessType;
    }

    public Integer getIndiExcessBase() {
        return indiExcessBase;
    }

    public void setIndiExcessBase(Integer indiExcessBase) {
        this.indiExcessBase = indiExcessBase;
    }

    public String getIndiCalculateStr() {
        return indiCalculateStr;
    }

    public void setIndiCalculateStr(String indiCalculateStr) {
        this.indiCalculateStr = indiCalculateStr;
    }

    public String getIndiIf() {
        return indiIf;
    }

    public void setIndiIf(String indiIf) {
        this.indiIf = indiIf;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

}