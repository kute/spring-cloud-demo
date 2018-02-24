package com.kute.eurekaclient02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClient02Application {

	public static void main(String[] args) {
//		SpringApplication.run(EurekaClient02Application.class, args);
		new SpringApplicationBuilder(EurekaClient02Application.class).web(true).run(args);
	}
}
