package com.kute.springcloudfunction.components;

import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * 方式一：@component + implements Function
 * created by bailong001 on 2020/01/30 15:58
 * <p>
 * http://localhost:8080/function/customFunction2/kute
 */
@Component
public class CustomFunction2 implements Function<String, String> {
    @Override
    public String apply(String s) {
        return (s + "customer2").toUpperCase();
    }
}
