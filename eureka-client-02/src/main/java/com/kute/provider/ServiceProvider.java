package com.kute.provider;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * created by kute on 2018/02/25 13:06
 */
@RestController
@RequestMapping("/api/v1")
public class ServiceProvider {

    private static final Logger logger = LoggerFactory.getLogger(ServiceProvider.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     *  获取 spring-cloud-eureka-client-01-application 的服务， 需要
     *  spring-cloud-eureka-client-01-application 服务先启动
     *
     * @refer  https://howtodoinjava.com/spring/spring-cloud/spring-cloud-service-discovery-netflix-eureka/
     * @param name
     * @return
     */
    @GetMapping("/get-service-from-client-01/{name}")
    public String getEurekaClient01Service(@PathVariable String name) {

        logger.info("go into spring-cloud-eureka-client-instance.02 service");

        JSONObject ret = new JSONObject();

        JSONObject infoObject = new JSONObject();
        infoObject.put("serviceName", "spring-cloud-eureka-client-instance.02");
        infoObject.put("version", 1.0);
        infoObject.put("desc", "client-instance.02-服务简介");

        ret.put("service-info", infoObject);

        /**
         * 注意 host 使用的是 instance-1的 spring.applicatioin.name
         */
        String url = "http://spring-cloud-eureka-client-01-application/api/v1/getUser/{name}";

        // get service from client.01-provider
        String response = restTemplate.exchange(
                url,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<String>(){},
                name).getBody();
        ret.put("get-service-from-client.01", JSONObject.parse(response));

        logger.info(ret.toJSONString());

        return ret.toJSONString();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
