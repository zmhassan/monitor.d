package com.bzcareer.monitord.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bzcareer.monitord.core.model.Users;
import com.bzcareer.monitord.core.repository.UserRepository;

@ComponentScan(basePackages = { 
		"com.bzcareer.monitord.core.controller",
		"com.bzcareer.monitord.core.model",
		"com.bzcareer.monitord.core.repository",
		"com.bzcareer.monitord.core.services" })
@SpringBootApplication
@EnableMongoRepositories(basePackages = { "com.bzcareer.monitord.core.repository" })
public class MondCoreServicesApplication {


	public static void main(String[] args) {
		SpringApplication.run(MondCoreServicesApplication.class, args);
	}
 

}
