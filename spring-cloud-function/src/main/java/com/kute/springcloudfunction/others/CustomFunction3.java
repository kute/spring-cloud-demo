package com.kute.springcloudfunction.others;

import java.util.function.Function;


public class CustomFunction3 implements Function<String, String> {
    @Override
    public String apply(String s) {
        return (s + "customer3").toUpperCase();
    }
}
