package com.example.chat.common.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 * 1. 可以直接创建带ResultCode的异常
 * 2. 可以直接重写getCode和getMessage方法
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1112016338120943968L;

    @Setter
    @Getter
    private BusinessError businessError;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(BusinessError businessError) {
        super(businessError.getMessage());
        this.businessError = businessError;
    }

    public BusinessException(String message, BusinessError businessError) {
        super(message);
        this.businessError = businessError;
    }

    public BusinessException(BusinessError businessError, Object... args) {
        super(businessError.getMessage(args));
        this.businessError = businessError;
    }

}
