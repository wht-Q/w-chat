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
    SYSTEM_ERROR(-1, "服务不可用"),

    DATA_CHECK_ERROR(40000, "数据校验异常"),
    // 400
    BAD_REQUEST(400, "请求数据格式不正确!"),
    UNAUTHORIZED(401, "登录凭证过期!"),
    FORBIDDEN(403, "没有访问权限!"),
    NOT_FOUND(404,"请求的资源找不到!"),
    // 500
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVICE_UNAVAILABLE(503, "服务器正忙，请稍后再试!"),
    // 未知异常
    UNKNOWN(10000, "未知异常!"),
    /**
     * 用戶40000-45000
     */
    /**
     * 用戶不存在
     */
    USER_NOT_FOUND(40001, "用户%s不存在"),
    /**
     * 用戶已存在
     */
    USER_EXISTED(40002, "用户%s已存在");

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
