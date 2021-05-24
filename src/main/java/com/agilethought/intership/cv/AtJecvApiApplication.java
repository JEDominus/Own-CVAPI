package com.agilethought.intership.cv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class AtJecvApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtJecvApiApplication.class, args);
	}

}
