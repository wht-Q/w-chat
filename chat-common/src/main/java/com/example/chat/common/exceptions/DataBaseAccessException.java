package com.example.chat.common.exceptions;


public class DataBaseAccessException extends BusinessException {
    private static final long serialVersionUID = 1112016338120943989L;

    public DataBaseAccessException(BusinessError businessError, Object... args) {
        super(businessError, args);
    }
}
