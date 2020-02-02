package com.kute.springcloudopenfeign.feigh.config.decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

/**
 * created by bailong001 on 2020/02/02 17:07
 */
@Component
public class IllegalArgumentExceptionOn404Decoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 400) {
            throw new IllegalArgumentException("bad zone name");
        }
        return new ErrorDecoder.Default().decode(methodKey, response);
    }
}
