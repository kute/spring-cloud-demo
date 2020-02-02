package com.kute.springcloudfunction.functions;

import java.util.function.Function;

/**
 * created by bailong001 on 2020/01/30 15:58
 * <p>
 * 方式三： 配置文件中 spring.cloud.function.scan.packages
 * 其中 Funciton 等 的bean扫描注册 在  ContextFunctionCatalogInitializer 类中
 * 将 bean添加到 FunctionCatalog 在 FunctionRegistrationPostProcessor
 */
public class CustomFunction implements Function<String, String> {
    @Override
    public String apply(String s) {
        return (s + "customer").toUpperCase();
    }
}
