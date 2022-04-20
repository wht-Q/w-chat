package com.example.chat.api.aop.unionauth.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.example.chat.check.Checker;
import com.example.chat.common.exceptions.BusinessException;
import com.example.chat.common.exceptions.ResultCode;
import com.example.chat.infrastructure.check.annotation.AnnotationCheck;

@Component
@Aspect
public class GeneralCheckAop {

    @Before(value = "@annotation(generalCheck)")
    public void before(JoinPoint point, AnnotationCheck generalCheck)
            throws InstantiationException, IllegalAccessException {
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] argValues = point.getArgs();
        Map<String, Object> args = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            args.put(parameterNames[i], argValues[i]);
        }
        Class[] checkers = generalCheck.checkers();
        for (Class checkerClz : checkers) {
            Checker checker = (Checker) checkerClz.newInstance();

            //是否校验成功
            if (!checker.check(args, methodSignature.getMethod())) {
                String message = checker.getExceptionMessage();
                throw new BusinessException(ResultCode.DATA_CHECK_ERROR, message);
            }
        }
    }
}
