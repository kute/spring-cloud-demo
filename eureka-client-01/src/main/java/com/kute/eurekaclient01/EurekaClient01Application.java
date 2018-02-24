package com.kute.eurekaclient01;

import com.alibaba.fastjson.JSONObject;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClient01Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaClient01Application.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient01Application.class, args);
	}

}
