package com.jesjesti.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = { "com.jesjesti.authorization.controller" })
@Configuration
@ComponentScan(basePackages = { "com.jesjesti.authorization.controller", "com.jesjesti.authorization.service",
		"com.jesjesti.authorization.config","com.jesjesti.authorization.utilities","com.jesjesti.authorization.filter" })
public class AuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}

}
