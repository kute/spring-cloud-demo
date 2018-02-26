package com.kute.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 命令行运行：  ./mvnw spring-boot:run
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServer02Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServer02Application.class, args);
	}
}
