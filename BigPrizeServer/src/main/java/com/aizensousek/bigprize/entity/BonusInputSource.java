package com.aizensousek.bigprize.entity;

import java.io.Serializable;

/**
 * (BonusInputSource)实体类
 *
 * @author aizensousek
 * @since 2022-06-20 15:29:59
 */
@SuppressWarnings("unused")
public class BonusInputSource implements Serializable {
    private static final long serialVersionUID = -53220004634543179L;

    private String id;

    private String modelId;

    private String sourceName;

    private String sourceInputType;

    private String sourceCode;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceInputType() {
        return sourceInputType;
    }

    public void setSourceInputType(String sourceInputType) {
        this.sourceInputType = sourceInputType;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

}