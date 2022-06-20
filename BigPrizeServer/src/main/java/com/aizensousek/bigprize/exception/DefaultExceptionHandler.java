package com.aizensousek.bigprize.exception;

import com.aizensousek.bigprize.domain.ResultCode;
import com.aizensousek.bigprize.domain.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;


@SuppressWarnings("rawtypes")
@RestControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

    /**
     * 处理所有自定义异常
     *
     * @param e 异常信息
     * @return 包装后的异常信息反馈
     */
    @ExceptionHandler(CustomException.class)
    public ResultJson handleCustomException(CustomException e) {
        log.error(e.getResultJson().getMsg());
        return e.getResultJson();
    }

    /**
     * 处理参数校验异常
     *
     * @param e 异常信息
     * @return 包装后的异常信息反馈
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultJson handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(Objects.requireNonNull(e.getBindingResult().getFieldError()).getField() + e.getBindingResult().getFieldError().getDefaultMessage());
        return ResultJson.failure(ResultCode.BAD_REQUEST, e.getBindingResult().getFieldError().getDefaultMessage());
    }
}