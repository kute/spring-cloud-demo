package com.kute.springcloudfunction.config;

import com.kute.springcloudfunction.functions.CustomFunction;
import com.kute.springcloudfunction.others.CustomFunction3;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionRegistry;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Function;

/**
 * created by bailong001 on 2020/01/30 15:44
 */
public class FunctionConfig implements ApplicationContextInitializer<GenericApplicationContext> {

    public Function<String, String> lowercase() {
        return String::toLowerCase;
    }

    @Override
    public void initialize(GenericApplicationContext applicationContext) {

        applicationContext.registerBean("lower",
                FunctionRegistration.class,
                () -> new FunctionRegistration<>(lowercase()).type(FunctionType.from(String.class).to(String.class)));

        applicationContext.registerBean("customFunction3",
                FunctionRegistration.class,
                () -> new FunctionRegistration<>(new CustomFunction3()).type(CustomFunction.class));


    }
}
