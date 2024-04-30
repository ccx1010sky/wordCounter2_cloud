package com.ccx2.wordCounter2_EurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WordCounter2EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordCounter2EurekaServerApplication.class, args);
	}

}
