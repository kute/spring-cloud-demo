package com.kute.springcloudstreamkafka.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * created by bailong001 on 2020/02/01 09:48
 */
@Data
@Accessors(chain = true)
public class Comment implements Serializable {

    private Long id;

    private String content;

    public Comment incrId(Long id) {
        this.id = this.id + id;
        return this;
    }
}
