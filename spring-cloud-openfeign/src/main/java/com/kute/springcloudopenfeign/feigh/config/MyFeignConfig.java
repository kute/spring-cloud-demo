package com.kute.springcloudopenfeign.feigh.config;

import com.kute.springcloudopenfeign.feigh.config.encoder.MyQueryMapEncoder;
import feign.Contract;
import feign.Logger;
import feign.QueryMapEncoder;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by bailong001 on 2020/02/02 16:25
 * <p>
 * 用于重新定义 {@link feign.codec.Decoder}, {@link feign.codec.Encoder}, {@link feign.Contract}
 */
@Configuration
public class MyFeignConfig {

    @Bean
    public QueryMapEncoder myQueryEncoder() {
        return new MyQueryMapEncoder();
    }

    @Bean
    public Logger.Level myLoggerLeve() {
        return Logger.Level.HEADERS;
    }

    @Bean
    public Decoder myDecoder() {
        return new Decoder.Default();
    }

    @Bean
    public Encoder myEncoder() {
        return new Encoder.Default();
    }

    @Bean
    public Contract myContract() {
        return new Contract.Default();
    }

}
