package com.aizensousek.bigprize.entity;

import java.math.BigDecimal;

/**
 * @author aizensousek
 * @since 创建于2022/6/20 15:51
 **/
public class BonusCalculateResult {
    private String indiName;
    private BigDecimal result;

    public String getIndiName() {
        return indiName;
    }

    public void setIndiName(String indiName) {
        this.indiName = indiName;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public BonusCalculateResult() {
    }

    public BonusCalculateResult(String indiName, BigDecimal result) {
        this.indiName = indiName;
        this.result = result;
    }
}