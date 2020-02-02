package com.kute.springcloudopenfeign.feigh.config.encoder;

import com.kute.springcloudopenfeign.entity.Comment;
import feign.QueryMapEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * created by bailong001 on 2020/02/02 17:33
 */
public class MyQueryMapEncoder implements QueryMapEncoder {

    @Override
    public Map<String, Object> encode(Object object) {
        if (object instanceof Comment) {
            Comment comment = (Comment) object;
            Map<String, Object> param = new HashMap<>(2);
            param.put("id", comment.getId());
            param.put("name", comment.getName());
            return param;
        }
        return null;
    }
}
