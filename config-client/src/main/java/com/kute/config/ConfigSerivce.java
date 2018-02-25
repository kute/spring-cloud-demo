package com.kute.config;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

/**
 * created by kute on 2018/02/25 20:31
 */
@RestController
@RequestMapping("/api/v1")
public class ConfigSerivce {

    private static final Logger logger = LoggerFactory.getLogger(ConfigSerivce.class);

    @Value("${current.user}")
    private String currentUser;

    @Value(("${current.label}"))
    private String currentLabele;

    @Value("${current.file.name}")
    private String currentFileName;

    @GetMapping("/getConfig")
    public String getConfig() {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("currentUser", currentUser);
        jsonObject.put("currentLabel", currentLabele);
        jsonObject.put("currentFileName", currentFileName);

        logger.info("get config from config server:{}", jsonObject);

        return jsonObject.toJSONString();
    }

}
