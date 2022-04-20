package com.example.chat.common.exceptions.interceptor;


import java.util.Optional;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.chat.common.exceptions.BusinessError;
import com.example.chat.common.exceptions.BusinessException;
import com.example.chat.common.exceptions.Response;
import com.example.chat.common.exceptions.ResultCode;

import lombok.extern.slf4j.Slf4j;

/**
 * RestControllerAdvice，统一异常处理
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerConfig {

    /**
     * 业务异常处理
     * @param e 业务异常
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public  Response<Object> exceptionHandler(BusinessException e) {
        log.warn("【ErrorHandler: {BusinessException}】", e);
//        log.error(ErrorUtil.errorInfoToString(e));
        BusinessError error = e.getBusinessError();
        String message = Optional.ofNullable(error).map(err -> getMessage(err, e)).orElse(e.getMessage());
        int code = Optional.ofNullable(error).map(BusinessError::getCode).orElse(4000);
        return Response.fail(code, message);
    }
    private String getMessage(BusinessError error, BusinessException e) {
        if (org.apache.commons.lang3.StringUtils.contains(error.getMessage(), "%s")) {
            return e.getMessage();
        }
        return error.getMessage();
    }
    /**
     * 未知异常处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response<Object> exceptionHandler(Exception e) {
        // 把错误信息输入到日志中
//        log.error(ErrorUtil.errorInfoToString(e));
        return Response.fail(ResultCode.UNKNOWN.getCode(), ResultCode.UNKNOWN.getMessage());
    }

//    /**
//     * 错误页面异常
//     */
//    @ExceptionHandler(value = ErrorPageException.class)
//    @ResponseBody
//    public Response<Object> exceptionHandler(ErrorPageException e) {
//        log.error(ErrorUtil.errorInfoToString(e));
//        return Response<Object>.error(e.getCode(), e.getErrorMsg());
//    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Response<Object> exceptionHandler(NullPointerException e) {
//        log.error(ErrorUtil.errorInfoToString(e));
        return Response.fail(ResultCode.INTERNAL_SERVER_ERROR.getCode(),
                ResultCode.INTERNAL_SERVER_ERROR.getMessage());
    }
}

