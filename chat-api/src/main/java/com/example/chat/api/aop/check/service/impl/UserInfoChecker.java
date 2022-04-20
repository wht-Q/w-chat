package com.example.chat.api.aop.check.service.impl;

import java.lang.reflect.Method;
import java.util.Map;

import com.example.chat.check.Checker;

public class UserInfoChecker implements Checker {
    @Override
    public boolean check(Map<String, Object> args, Method method) {

        return true;
    }

    @Override
    public String getExceptionMessage() {
        return "当前接口仅支持管理员操作";
    }
}
