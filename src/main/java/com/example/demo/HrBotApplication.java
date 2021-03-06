package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
@EnableConfigurationProperties
@EntityScan(basePackages = { "com.example.entity" })
@ComponentScan(basePackages = { "com.example.controller" })
@EnableJpaRepositories(basePackages = { "com.example.repository" })
@ComponentScan
public class HrBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrBotApplication.class, args);
	}

}
