package com.kute.configclient;

import com.kute.config.ConfigSerivce;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@ComponentScan(basePackageClasses = ConfigSerivce.class)
@RestController
@SpringBootApplication
public class ConfigClientApplication {

    @GetMapping("/")
    public String home() {
        return "spring-cloud-config-client-home-api";
    }

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}
