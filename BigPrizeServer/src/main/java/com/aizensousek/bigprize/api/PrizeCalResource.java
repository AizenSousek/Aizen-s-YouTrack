package com.aizensousek.bigprize.api;

import com.aizensousek.bigprize.constants.BonusCalculateConstant;
import com.aizensousek.bigprize.constants.BonusInputSourceTypeConstant;
import com.aizensousek.bigprize.entity.*;
import com.aizensousek.bigprize.entity.vo.BonusModelVo;
import com.aizensousek.bigprize.service.BonusCalculateIndicatorService;
import com.aizensousek.bigprize.service.BonusInputSourceService;
import com.aizensousek.bigprize.service.BonusLadderService;
import com.aizensousek.bigprize.service.BonusModelService;
import com.aizensousek.bigprize.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 奖金模型计算API
 *
 * @author aizensousek
 * @since 创建于2022/6/20 15:47
 **/
@RestController
@RequestMapping("prizeCalApi")
public class PrizeCalResource {

    private ScriptEngineManager scriptEngineManager;

    private final String FORMUL_REGEX = "\\$\\{.*?}";
    private BonusModelService bonusModelService;
    private BonusInputSourceService bonusInputSourceService;
    private BonusLadderService bonusLadderService;
    private BonusCalculateIndicatorService bonusCalculateIndicatorService;

    @Autowired
    public PrizeCalResource(BonusModelService bonusModelService, BonusInputSourceService bonusInputSourceService, BonusLadderService bonusLadderService, BonusCalculateIndicatorService bonusCalculateIndicatorService) {
        this.bonusModelService = bonusModelService;
        this.bonusInputSourceService = bonusInputSourceService;
        this.bonusLadderService = bonusLadderService;
        this.bonusCalculateIndicatorService = bonusCalculateIndicatorService;
    }


    @PostMapping("calculate")
    public BonusModelVo calculate(@RequestBody BonusModelVo model) {
        // 首先获取到输入的数据源
        List<BonusInputSource> inputSourceList = model.getInputSourceList();
        // 获取到计算的各个指标
        List<BonusCalculateIndicator> indicators = model.getIndicators();
        List<BonusCalculateResult> calculateResults = new ArrayList<>();
        for (BonusCalculateIndicator indicator : indicators) {
            String indiType = indicator.getIndiType();
            if (indiType.equals(BonusCalculateConstant.BONUS_CALCULATE_TYPE_LADDER)){
                List<BonusLadder> ladders = indicator.getLadders();
                BigDecimal laddersBonus = BigDecimal.valueOf(0);
                for (BonusLadder ladder : ladders) {
                    BigDecimal minLadder = BigDecimal.valueOf(ladder.getMinLadder());
                    BigDecimal maxLadder = BigDecimal.valueOf(ladder.getMaxLadder());
                    String calculateSource = ladder.getCalculateSource();
                    BigDecimal sourceValue = NumberUtils.createBigDecimal(getInputValueBySourceCode(inputSourceList, calculateSource));
                    if (sourceValue.compareTo(minLadder) < 0){
                        continue;
                    }
                    Object formulResult = null;
                    if (maxLadder.compareTo(sourceValue) <= 0) {
                        String maxCalculateFormul = ladder.getMaxLadderCalculateStr();
                        formulResult = getFormulResult(inputSourceList, maxCalculateFormul);
                    } else {
                        String indiCalculateStr = ladder.getIndiCalculateStr();
                        formulResult = getFormulResult(inputSourceList, indiCalculateStr);
                    }
                    laddersBonus = laddersBonus.add(NumberUtils.createBigDecimal(String.valueOf(formulResult)));
                }
                BonusCalculateResult calculateResult = new BonusCalculateResult();
                calculateResult.setIndiName(indicator.getIndiName());
                calculateResult.setResult(laddersBonus);
                calculateResults.add(calculateResult);
            }else {
                String ifFormul = indicator.getIndiIf();
                // 针对每个指标进行公式计算,首先要确认条件
                if (Boolean.parseBoolean(String.valueOf(getFormulResult(inputSourceList,ifFormul)))){
                    String calFormul = indicator.getIndiCalculateStr();
                    // 获取计算公式并得到计算的结果
                    Object formulResult = getFormulResult(inputSourceList, calFormul);
                    // 增加结果到返回数据中,后面要模拟给到一个计算过程
                    BonusCalculateResult calculateResult = new BonusCalculateResult();
                    calculateResult.setIndiName(indicator.getIndiName());
                    calculateResult.setResult(NumberUtils.createBigDecimal(String.valueOf(formulResult)));
                    calculateResults.add(calculateResult);
                }
            }
        }
        // 保存结果到数据集中
        model.setCalculateResults(calculateResults);
        model.setCount(calCount(calculateResults));
        return model;
    }


    @PostMapping("saveModel")
    public BonusModelVo saveModel(@RequestBody BonusModelVo model){
        // 保存model
        BonusModel bonusModel = new BonusModel();
        bonusModel.setId(UUIDUtils.getUUIDString());
        bonusModel.setName(model.getName());
        bonusModel.setRemark(model.getRemark());
        bonusModelService.insert(bonusModel);
        // 保存成果后更新vo信息便于返回
        model.setId(bonusModel.getId());
        return model;
    }

    @PostMapping("updateModel")
    public BonusModel updateModel(@RequestBody BonusModel modelVo){
        return bonusModelService.update(modelVo);
    }

    @PostMapping("saveInputSource")
    public BonusInputSource saveInputSource(@RequestBody BonusInputSource source){
        BonusInputSource inputSource = new BonusInputSource();
        inputSource.setId(UUIDUtils.getUUIDString());
        inputSource.setSourceCode(UUIDUtils.getUUIDString());
        inputSource.setSourceInputType(source.getSourceInputType());
        inputSource.setSourceName(source.getSourceName());
        return bonusInputSourceService.insert(inputSource);
    }

    @PostMapping("updateInputSource")
    public BonusInputSource updateInputSource(@RequestBody BonusInputSource source){
        return bonusInputSourceService.update(source);
    }

    @PostMapping("saveIndicator")
    public BonusCalculateIndicator saveIndiactor(@RequestBody BonusCalculateIndicator indicator){
        BonusCalculateIndicator calculateIndicator = new BonusCalculateIndicator();
        calculateIndicator.setId(UUIDUtils.getUUIDString());
        calculateIndicator.setModelId(indicator.getModelId());
        calculateIndicator.setIndiName(indicator.getIndiName());
        calculateIndicator.setIndiType(indicator.getIndiType());
        calculateIndicator.setIndiComment(indicator.getIndiComment());
        calculateIndicator.setIndiCalculateStr(indicator.getIndiCalculateStr());
        calculateIndicator.setIndiIf(indicator.getIndiIf());
        return bonusCalculateIndicatorService.insert(calculateIndicator);
    }

    @PostMapping("updateIndicator")
    public BonusCalculateIndicator updateIndicator(@RequestBody BonusCalculateIndicator indicator) {
        return bonusCalculateIndicatorService.update(indicator);
    }

    @PostMapping("saveLadder")
    public BonusLadder saveLadder(@RequestBody BonusLadder ladder){
        BonusLadder bonusLadder = new BonusLadder();
        bonusLadder.setId(UUIDUtils.getUUIDString());
        bonusLadder.setIndiId(ladder.getIndiId());
        bonusLadder.setMinLadder(ladder.getMinLadder());
        bonusLadder.setMaxLadder(ladder.getMaxLadder());
        bonusLadder.setCalculateSource(ladder.getCalculateSource());
        bonusLadder.setMaxLadderCalculateStr(ladder.getMaxLadderCalculateStr());
        bonusLadder.setIndiCalculateStr(ladder.getIndiCalculateStr());
        return bonusLadderService.insert(bonusLadder);
    }

    @PostMapping("updateLadder")
    public BonusLadder updateLadder(@RequestBody BonusLadder ladder) {
        return bonusLadderService.update(ladder);
    }



    private String getIndiType(String indiType) {
        switch (indiType)
        {
            case "normal":
                return BonusCalculateConstant.BONUS_CALCULATE_TYPE_NORMAL;
            case "ladder":
                return BonusCalculateConstant.BONUS_CALCULATE_TYPE_LADDER;
        }
        return null;
    }

    private String getModelInputSourceType(BonusInputSource source) {
        switch (source.getSourceInputType()){
            case "number" :
                return BonusInputSourceTypeConstant.BONUS_INPUT_SOURCE_TYPE_NUMBER;
            case "percent":
                return BonusInputSourceTypeConstant.BONUS_INPUT_SOURCE_TYPE_PERCENT;
            default:
        }
        return null;
    }

    private BigDecimal calCount(List<BonusCalculateResult> calculateResults) {
        BigDecimal count = BigDecimal.valueOf(0);
        for (BonusCalculateResult calculateResult : calculateResults) {
            count = count.add(calculateResult.getResult());
        }
        return count;
    }

    private Object getFormulResult(List<BonusInputSource> inputSourceList, String formul){
        if (StringUtils.isNotEmpty(formul)) {
            ScriptEngine scriptEngine = getScriptEngineManager().getEngineByName("nashorn");
            Pattern compile = Pattern.compile(FORMUL_REGEX);
            Matcher matcher = compile.matcher(formul);
            while (matcher.find()){
                String group = matcher.group();
                String code = group.substring(2, group.length() - 1);
                String value = getInputValueBySourceCode(inputSourceList, code);
                formul = formul.replace(group, value);
            }
            try {
                return scriptEngine.eval(formul);
            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
    private String getInputValueBySourceCode(List<BonusInputSource> inputSourceList, String sourceCode) {
        for (BonusInputSource source : inputSourceList) {
            if (source.getSourceCode().equals(sourceCode)){
                return source.getValue();
            }
        }
        return "0";
    }

    public ScriptEngineManager getScriptEngineManager() {
        if (scriptEngineManager == null) {
            scriptEngineManager = new ScriptEngineManager();
        }
        return scriptEngineManager;
    }

    public void setScriptEngineManager(ScriptEngineManager scriptEngineManager) {
        this.scriptEngineManager = scriptEngineManager;
    }

    public static void main(String[] args) {
        System.out.println(UUIDUtils.getUUIDString());
    }
}