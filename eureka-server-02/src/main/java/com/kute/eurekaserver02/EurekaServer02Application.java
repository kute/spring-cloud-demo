package com.kute.eurekaserver02;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer02Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer02Application.class, args);
	}

	@GetMapping("/info")
	public String getMyService() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("serviceName", "spring-cloud-eureka-server-instance.02");
		jsonObject.put("version", 1.0);
		jsonObject.put("url", "/info");
		jsonObject.put("desc", "服务简介");

		return jsonObject.toJSONString();
	}
}
