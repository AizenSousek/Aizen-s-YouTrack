package com.aizensousek.aytserver.exception;

import com.aizensousek.aytserver.domain.ResultJson;
import lombok.Getter;


@SuppressWarnings("rawtypes")
@Getter
public class CustomException extends RuntimeException {
    private final ResultJson resultJson;

    public CustomException(ResultJson resultJson) {
        this.resultJson = resultJson;
    }
}