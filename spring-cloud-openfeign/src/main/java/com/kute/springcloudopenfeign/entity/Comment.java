package com.kute.springcloudopenfeign.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * created by bailong001 on 2020/02/02 17:13
 */
@Data
@Accessors(chain = true)
public class Comment implements Serializable {

    private String id;

    private String name;
}
