package com.example.chat.infrastructure.check.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.chat.check.Checker;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationCheck {

    Class<? extends Checker>[] checkers();
}