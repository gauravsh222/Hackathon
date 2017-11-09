package com.cisco.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.cisco")
public class CiscoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiscoApplication.class, args);
	}
}
