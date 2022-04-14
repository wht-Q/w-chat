package com.example.chat.common.exceptions.base;

import com.example.chat.common.exceptions.ResultCode;

public class BaseRuntimeException extends RuntimeException implements ExceptionInterface {

    public ResultCode resultCode = ResultCode.FAIL;

    public BaseRuntimeException() {

    }

    public BaseRuntimeException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String getMessage() {
        return resultCode.getMessage();
    }

    @Override
    public int getCode() {
        return resultCode.getCode();
    }
}
