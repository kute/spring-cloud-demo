package com.kute.provider;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者
 * created by kute on 2018/02/25 11:25
 */
@RestController
@RequestMapping("/api/v1")
public class ServiceProvider {

    private static final Logger logger = LoggerFactory.getLogger(ServiceProvider.class);

    /**
     * 其他服务
     * @param name
     * @return
     */
    @GetMapping("/getUser/{name}")
    public String getMyService(@PathVariable String name) {

        logger.info("request service:{}", name);

        JSONObject ret = new JSONObject();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", name);
        jsonObject.put("id", "10001");
        jsonObject.put("age", 18);

        ret.put("user", jsonObject);

        JSONObject infoObject = new JSONObject();
        infoObject.put("serviceName", "spring-cloud-eureka-client-instance.01");
        infoObject.put("version", 1.0);
        infoObject.put("desc", "client-instance.01-服务简介");

        ret.put("service-info", infoObject);

        logger.info(ret.toJSONString());

        return ret.toJSONString();
    }

}
