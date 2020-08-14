package com.jesjesti.user.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = { "com.jesjesti.user.management.controller" })
@Configuration
@ComponentScan(basePackages = { "com.jesjesti.user.management.controller", "com.jesjesti.user.management.service",
		"com.jesjesti.user.management.authentication" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
