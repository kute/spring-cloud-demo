package com.kute.springcloudstreamkafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by bailong001 on 2020/01/31 11:20
 */
@Configuration
public class StreamConfig {

    @Bean
    public CustomPartitionKeyExtractor customPartitionKeyExtractor() {
        return new CustomPartitionKeyExtractor();
    }

    @Bean
    public CustomPartitionSelectorStrategy customPartitionSelectorStrategy() {
        return new CustomPartitionSelectorStrategy();
    }

}
