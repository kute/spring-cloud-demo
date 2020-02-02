package com.kute.springcloudfunction;

import com.kute.springcloudfunction.config.FunctionConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.catalog.FunctionCatalogEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.function.Function;

/**
 * 将 function bean 暴露为 endpoint url在 FunctionEndpointInitializer
 */
@SpringBootApplication
@Slf4j
public class SpringCloudFunctionApplication implements ApplicationListener<FunctionCatalogEvent> {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringCloudFunctionApplication.class, args);

        /**
         * 默认 InMemoryFunctionCatalog 实例
         */
        FunctionCatalog catalog = applicationContext.getBean(FunctionCatalog.class);
        log.info("=====================");
        log.info("size={}", catalog.size());
        log.info("getNames={}", catalog.getNames(Function.class));
        log.info("=====================");

    }

    @Override
    public void onApplicationEvent(FunctionCatalogEvent functionCatalogEvent) {
        log.info("SpringCloudFunctionApplication receive functionCatalogEvent={}", functionCatalogEvent);
    }
}
