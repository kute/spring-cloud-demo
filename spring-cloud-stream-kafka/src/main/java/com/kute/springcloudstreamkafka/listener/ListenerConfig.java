package com.kute.springcloudstreamkafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

/**
 * created by bailong001 on 2020/01/31 15:01
 */
@Configuration
@Slf4j
public class ListenerConfig {

//    @StreamListener(value = "streamListenerProcessMessage")
//    public void streamListenerProcessMessage(Message<?> message) {
//        log.info("streamListenerProcessMessage receive={}", message);
//    }

}
