package com.kute.springcloudstreamkafka.functions;

import com.alibaba.fastjson.JSONObject;
import com.kute.springcloudstreamkafka.entity.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * created by bailong001 on 2020/01/31 23:11
 */
@Configuration
@Slf4j
public class ConfigOnTest {

//    /**
//     * Supplier<String> 每秒调用一次
//     * @return
//     */
//    @ConditionalOnProperty(prefix = "current.environment", name = "active", havingValue = "test")
//    @Bean
//    public Supplier<String> simpleSupplier() {
//        return () -> {
//            String message =
//                    JSONObject.toJSONString(new Comment()
//                            .setId(11L)
//                            .setContent("what"));
//            log.info("simpleSupplier produce message={}", message);
//            return message;
//        };
//    }

    /**
     * Supplier<Flux<String>> 只在 启动时调用一次，如果需要无限数据需要自己控制
     * 这里也实现了 每秒生产一条消息
     *
     * @return
     */
    @ConditionalOnProperty(prefix = "current.environment", name = "active", havingValue = "test")
    @Bean
    public Supplier<Flux<String>> simpleSupplier() {
        return () -> {
            Comment comment = new Comment()
                    .setId(11L)
                    .setContent("what");
            return Flux.interval(Duration.ofSeconds(5L))
                    .map(i -> JSONObject.toJSONString(comment.incrId(1L)))
                    .doOnEach(ms -> {
                        log.info("simpleSupplier produce message={}", ms);
                    });
        };
    }

    /**
     * 测试 function
     *
     * @return
     */
    @ConditionalOnProperty(prefix = "current.environment", name = "active", havingValue = "test")
    @Bean
    public Function<String, Comment> simpleCommentFunction() {
        return value -> {
            log.info("simpleCommentFunction receive message={}", value);
            return new Comment().setId(new Random().nextLong()).setContent(value);
        };
    }

    @ConditionalOnProperty(prefix = "current.environment", name = "active", havingValue = "test")
    @Bean
    public Function<String, String> simpleFunction() {
        return value -> {
            log.info("simpleFunction receive message={}", value);
            return value;
        };
    }

    @ConditionalOnProperty(prefix = "current.environment", name = "active", havingValue = "test")
    @Bean
    public Consumer<Comment> simpleConsumer() {
        return value -> {
            log.info("Receive comment message={}", value);
            if (value.getId() > 300) {
                // 模拟异常重试，重试之后还异常就抛出
                throw new IllegalArgumentException("Illegal id fro comment=" + value);
            }
        };
    }

}
