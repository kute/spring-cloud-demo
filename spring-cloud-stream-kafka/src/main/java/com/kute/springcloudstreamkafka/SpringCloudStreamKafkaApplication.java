package com.kute.springcloudstreamkafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@Slf4j
public class SpringCloudStreamKafkaApplication {

//
//    @Bean
//    public Supplier<Flux<String>> stringReactiveSupplier() {
//        return () -> Flux.from(emitter -> {
//            while (true) {
//                try {
//                    emitter.onNext("Hello from Supplier");
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    // ignore
//                }
//            }
//        });
//    }

//    @Bean
//    public Supplier<String> stringSupplier() {
//        return () -> {
//            long time = System.currentTimeMillis();
//            log.info("stringSupplier time={}", time);
//            return String.valueOf(time);
//        };
//    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudStreamKafkaApplication.class)
                .web(WebApplicationType.REACTIVE).run(args);
    }

}
