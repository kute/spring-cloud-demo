package com.kute.springcloudopenfeign.feigh.config.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.encoding.BaseRequestInterceptor;
import org.springframework.cloud.openfeign.encoding.FeignClientEncodingProperties;
import org.springframework.stereotype.Component;

/**
 * created by bailong001 on 2020/02/02 16:42
 */
@Component
@Slf4j
public class MyRequestInterceptor extends BaseRequestInterceptor {
    /**
     * Creates new instance of {@link BaseRequestInterceptor}.
     *
     * @param properties the encoding properties
     */
    protected MyRequestInterceptor(FeignClientEncodingProperties properties) {
        super(properties);
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("MyRequestInterceptor headers={}", requestTemplate.headers());
    }
}
