package com.aizensousek.bigprize.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (BonusCalculateIndicator)实体类
 *
 * @author aizensousek
 * @since 2022-06-21 14:00:28
 */
@SuppressWarnings("unused")
public class BonusCalculateIndicator implements Serializable {
    private static final long serialVersionUID = -74449637002418627L;

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
    private List<BonusLadder> ladders;
    /**
     * 指标计算公式（以空格分隔)
     */
    private String indiCalculateStr;

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

    public List<BonusLadder> getLadders() {
        return ladders;
    }

    public void setLadders(List<BonusLadder> ladders) {
        this.ladders = ladders;
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

    public BonusCalculateIndicator() {
    }

    public BonusCalculateIndicator(String id, String indiName, String indiComment, String indiType, List<BonusLadder> ladders, String indiCalculateStr, String indiIf, String modelId) {
        this.id = id;
        this.indiName = indiName;
        this.indiComment = indiComment;
        this.indiType = indiType;
        this.ladders = ladders;
        this.indiCalculateStr = indiCalculateStr;
        this.indiIf = indiIf;
        this.modelId = modelId;
    }

    /**
     * 指标计算条件（以空格进行分隔)
     */
    private String indiIf;
    /**
     * 所属模型ID
     */
    private String modelId;


}