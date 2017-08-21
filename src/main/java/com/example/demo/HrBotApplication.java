package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.controller" })
@LineMessageHandler
public class HrBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrBotApplication.class, args);
	}
}
