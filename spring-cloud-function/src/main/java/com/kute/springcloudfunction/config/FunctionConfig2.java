package com.kute.springcloudfunction.config;

import org.springframework.cloud.function.compiler.FunctionCompiler;
import org.springframework.cloud.function.compiler.proxy.LambdaCompilingFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ByteArrayResource;

import java.util.function.Function;

/**
 * created by bailong001 on 2020/01/30 16:28
 * <p>
 * 方式二：@Configuration + @Bean function
 */
@Configuration
public class FunctionConfig2 {

    /**
     * spring cloud function beans
     * <p>
     * http://localhost:8080/function/uppercase/kute
     *
     * @return
     */
    @Bean
    public Function<String, String> uppercase() {
        return String::toUpperCase;
    }

    /**
     * 将 字符串 编译为  function
     *
     * @return
     */
    @Bean
    public Function<String, String> compiledUppercase() {
        String lambda = "s -> s.toUpperCase()";
        LambdaCompilingFunction<String, String> function = new LambdaCompilingFunction<>(
                new ByteArrayResource(lambda.getBytes()), compiler());
        function.setTypeParameterizations("String", "String");
        return function;
    }

    @Bean
    public <T, R> FunctionCompiler<T, R> compiler() {
        return new FunctionCompiler<>();
    }
}
