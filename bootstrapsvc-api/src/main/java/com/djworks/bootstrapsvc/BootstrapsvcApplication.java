package com.djworks.bootstrapsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.djworks")
public class BootstrapsvcApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BootstrapsvcApplication.class, args);
	}
}
