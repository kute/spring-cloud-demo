package com.kute.server;

import com.alibaba.fastjson.JSONObject;
import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer01Application {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EurekaServer01Application.class);

	public static void main(String[] args) {
//		SpringApplication.run(EurekaServerApplication.class, args);
        new SpringApplicationBuilder(EurekaServer01Application.class).web(true).run(args);
	}
}
