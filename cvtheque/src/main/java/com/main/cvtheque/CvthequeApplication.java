package com.main.cvtheque;

import com.main.cvtheque.property.CVProperties;
import com.main.cvtheque.service.CVService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CVProperties.class)
public class CvthequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvthequeApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CVService cvService) {
		return (args) -> {
			cvService.deleteAll();
			cvService.init();
		};
	}
}
