package com.kute.springcloudstreamkafka.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.messaging.Message;

/**
 * created by bailong001 on 2020/01/31 11:12
 * 用于 提取 “用于筛选目标partition的”消息的key
 */
@Slf4j
public class CustomPartitionKeyExtractor implements PartitionKeyExtractorStrategy {
    @Override
    public Object extractKey(Message<?> message) {
        log.info("extractKey for message={}", message);
        // 这里 用 消息的 hashCode作为key来挑选目标partition，实际中可以用 消息中的id等其他字段
        return message.hashCode();
    }
}
