package com.bzcareer.monitord.core.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.bzcareer.monitord.core.controller"})
@SpringBootApplication
public class MondCoreServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MondCoreServicesApplication.class, args);
	}
}
