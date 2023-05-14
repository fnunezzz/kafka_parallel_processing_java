package com.github.fnunezzz.kafkaparallelprocessingjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@Import(AppConfig.class)
public class ApplicationConfiguration {
	enum Profile {
		dev, test
	}

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, Profile.dev.toString());
		String profile = System.getProperty("spring.profiles.active") != null ?
				System.getProperty("spring.profiles.active") :
				System.getProperty("spring.profiles.default");
		printProfile(Profile.valueOf(profile));
		SpringApplication.run(ApplicationConfiguration.class, args);
	}

	private static void printProfile(Profile mode) {
		System.out.println("---------------------------------------------");
		switch (mode) {
			case dev: {
				System.out.println("DEVELOPMENT MODE");
				break;
			}
			case test: {
				System.out.println("TESTING MODE");
				break;
			}
		}
		System.out.println("---------------------------------------------");
	}

}
