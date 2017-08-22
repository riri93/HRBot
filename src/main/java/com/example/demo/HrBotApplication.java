package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entity.HairSalon;
import com.example.repository.HairSaloonRepository;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

@SpringBootApplication
@LineMessageHandler
@EnableConfigurationProperties
@EntityScan(basePackages = { "com.example.entity" })
@ComponentScan(basePackages = { "com.example.controller" })
@EnableJpaRepositories(basePackages = { "com.example.repository" })
@ComponentScan
public class HrBotApplication implements CommandLineRunner {

	@Autowired
	HairSaloonRepository hairSaloonRepository;

	public static void main(String[] args) {
		SpringApplication.run(HrBotApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		hairSaloonRepository.save(new HairSalon("hair1", "Europe"));
		hairSaloonRepository.save(new HairSalon("hair2", "Asia"));
		hairSaloonRepository.save(new HairSalon("hair3", "Russia"));
		hairSaloonRepository.save(new HairSalon("hair4", "Africa"));
	}

}
