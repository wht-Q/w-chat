package com.example.chat.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode implements BusinessError {

    /**
     * 成功访问
     */
    SUCCESS(0, "成功"),
    /**
     * 失败访问
     */
    FAIL(1, "失败"),
    /**
     * 系统错误
     */
    SYSTEM_ERROR(-1, "服务不可用");

    @Getter
    private final int code;
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getMessage(Object... args) {
        try {
            return String.format(message, args);
        } catch (Exception e) {
            return message;
        }
    }
}
