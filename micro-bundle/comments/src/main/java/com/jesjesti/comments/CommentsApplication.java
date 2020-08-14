package com.jesjesti.comments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = { "com.jesjesti.comments.controller" })
@Configuration
@ComponentScan(basePackages = { "com.jesjesti.comments.controller", "com.jesjesti.comments.service",
		"com.jesjesti.comments.authentication" })
public class CommentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentsApplication.class, args);
	}

}
