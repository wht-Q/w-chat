package com.example.chat.check;

import java.lang.reflect.Method;
import java.util.Map;

public interface Checker {

    /**
     * 具体校验规则
     */
    boolean check(Map<String, Object> args, Method method);

    /**
     * 若校验失败，抛出异常，通过该方法定义要发送的异常信息
     */
    String getExceptionMessage();
}