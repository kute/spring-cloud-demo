package com.kute.springcloudfunction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;

import java.util.function.Function;

@SpringBootTest
@FunctionalSpringBootTest
class SpringCloudFunctionApplicationTests {

    /**
     * init in org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration#functionCatalog(java.util.Map, com.fasterxml.jackson.databind.ObjectMapper)
     */
    @Autowired
    private FunctionCatalog catalog;

    @Test
    void test() {
        Function<String, String> function = catalog.lookup(Function.class,
                "uppercase");
        Assertions.assertEquals(function.apply("hello"), "HELLO");
    }

}
