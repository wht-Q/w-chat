package com.example.chat.common.exceptions;

/**
 * <p>
 * 自定义 返回结果数据结构 接口
 */
public interface BusinessError {

    /**
     * 返回码
     *
     * @return 自定义状态码
     */
    int getCode();

    /**
     * 返回错误信息
     *
     * @return 错误信息
     */
    String getMessage();

    /**
     * 返回错误信息
     * @param args 报错参数，填充%s
     * @return 错误信息
     */
    String getMessage(Object... args);
}
