package com.example.chat.api.aop.unionauth.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.chat.check.Checker;
import com.example.chat.common.exceptions.BusinessException;
import com.example.chat.common.exceptions.ResultCode;
import com.example.chat.infrastructure.check.annotation.AnnotationCheck;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class GeneralCheckAspect {

    @Before(value = "@annotation(annotationCheck)")
    public void before(JoinPoint joinPoint, AnnotationCheck annotationCheck)
            throws InstantiationException, IllegalAccessException {
        log.debug("参数 : " + Arrays.toString(joinPoint.getArgs()));
        // 记录下请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();
        log.debug("请求地址 : " + request.getRequestURL().toString());
        log.debug("HTTP METHOD : " + request.getMethod());
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] argValues = joinPoint.getArgs();
        Map<String, Object> args = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            args.put(parameterNames[i], argValues[i]);
        }
        Class[] checkers = annotationCheck.checkers();
        for (Class checkerClz : checkers) {
            Checker checker = (Checker) checkerClz.newInstance();

            //是否校验成功
            if (!checker.check(args, methodSignature.getMethod())) {
                String message = checker.getExceptionMessage();
                throw new BusinessException(ResultCode.DATA_CHECK_ERROR, message);
            }
        }
    }

    @After(value = "@annotation(annotationCheck)")
    public void after(JoinPoint point, AnnotationCheck annotationCheck)
            throws InstantiationException, IllegalAccessException {
    }
    @After(value = "@annotation(annotationCheck)")
    public void doAfter(JoinPoint joinPoint, AnnotationCheck annotationCheck){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName+"方法执行后...");
    }
//
//    @AfterReturning(value = "execution(* com.wuwl.service.impl.StudentServiceImpl.*(..) )" , returning = "returning")
//    public void doReturn(JoinPoint joinPoint,Object returning){
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println(methodName+"方法返回，返回值为:"+returning);
//
//    }
//
//    @AfterThrowing(value = "execution(* com.wuwl.service.impl.StudentServiceImpl.*(..) )",throwing = "ex")
//    public void doThrow(JoinPoint joinPoint,Exception ex){
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println(methodName+"方法异常，异常信息为："+ex.getMessage());
//    }
}
