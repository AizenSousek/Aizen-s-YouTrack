package com.aizensousek.bigprize.entity;

import java.io.Serializable;

/**
 * (BonusInputSource)实体类
 *
 * @author aizensousek
 * @since 2022-06-21 14:00:27
 */
@SuppressWarnings("unused")
public class BonusInputSource implements Serializable {
    private static final long serialVersionUID = 245320393281209207L;

    private String id;

    private String modelId;

    private String sourceName;

    private String sourceInputType;

    private String sourceCode;

    private String value;


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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BonusInputSource() {
    }

    public BonusInputSource(String id, String modelId, String sourceName, String sourceInputType, String sourceCode, String value) {
        this.id = id;
        this.modelId = modelId;
        this.sourceName = sourceName;
        this.sourceInputType = sourceInputType;
        this.sourceCode = sourceCode;
        this.value = value;
    }
}