package com.kute.eurekaclient01;

import com.alibaba.fastjson.JSONObject;
import com.kute.provider.ServiceProvider;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@EnableEurekaClient
@EnableDiscoveryClient
@ComponentScans({
        @ComponentScan(basePackageClasses = ServiceProvider.class)
})
@SpringBootApplication
public class EurekaClient01Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaClient01Application.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient01Application.class, args);
	}

    @GetMapping("/info")
    public String getMyService() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("serviceName", "spring-cloud-eureka-client-instance.01");
        jsonObject.put("version", 1.0);
        jsonObject.put("url", "/info");
        jsonObject.put("desc", "服务简介");

        return jsonObject.toJSONString();
    }

}
