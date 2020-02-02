package com.kute.springcloudstreamkafka.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.binder.PartitionSelectorStrategy;

/**
 * created by bailong001 on 2020/01/31 11:19
 * 用于 挑选目标partition的策略
 */
@Slf4j
public class CustomPartitionSelectorStrategy implements PartitionSelectorStrategy {
    @Override
    public int selectPartition(Object key, int partitionCount) {
        log.info("selectPartition for key={}, partitionCount={}", key, partitionCount);
        // 这里的key是 通过 CustomPartitionKeyExtractor 提取出的
        // 默认的计算规则是：key.hashCode() % partitionCount
        return ((Integer) key) % partitionCount;
    }
}
