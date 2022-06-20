package com.aizensousek.bigprize.entity.vo;

import com.aizensousek.bigprize.entity.BonusCalculateIndicator;
import com.aizensousek.bigprize.entity.BonusCalculateResult;
import com.aizensousek.bigprize.entity.BonusInputSource;

import java.math.BigDecimal;
import java.util.List;

/**
 * 奖金模型[展示模型]
 *
 * @author aizensousek
 * @since 创建于2022/6/20 15:34
 **/
public class BonusModelVo {
    private String id;
    private String name;
    private String remark;
    private List<BonusInputSource> inputSourceList;
    private List<BonusCalculateIndicator> indicators;
    private List<BonusCalculateResult> calculateResults;
    private BigDecimal count;

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

    public List<BonusInputSource> getInputSourceList() {
        return inputSourceList;
    }

    public void setInputSourceList(List<BonusInputSource> inputSourceList) {
        this.inputSourceList = inputSourceList;
    }

    public List<BonusCalculateIndicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<BonusCalculateIndicator> indicators) {
        this.indicators = indicators;
    }

    public List<BonusCalculateResult> getCalculateResults() {
        return calculateResults;
    }

    public void setCalculateResults(List<BonusCalculateResult> calculateResults) {
        this.calculateResults = calculateResults;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BonusModelVo() {
    }

    public BonusModelVo(String id, String name, String remark, List<BonusInputSource> inputSourceList, List<BonusCalculateIndicator> indicators, List<BonusCalculateResult> calculateResults, BigDecimal count) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.inputSourceList = inputSourceList;
        this.indicators = indicators;
        this.calculateResults = calculateResults;
        this.count = count;
    }
}