package com.cisco.Device_OnBoarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.cisco")
public class DeviceOnBoardingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DeviceOnBoardingApplication.class, args);
	}
}
