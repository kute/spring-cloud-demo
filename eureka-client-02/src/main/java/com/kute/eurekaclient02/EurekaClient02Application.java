package com.kute.eurekaclient02;

import com.kute.provider.ServiceProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScans({
		@ComponentScan(basePackageClasses = ServiceProvider.class)
})
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClient02Application {

	public static void main(String[] args) {
//		SpringApplication.run(EurekaClient02Application.class, args);
		new SpringApplicationBuilder(EurekaClient02Application.class).web(true).run(args);
	}
}
