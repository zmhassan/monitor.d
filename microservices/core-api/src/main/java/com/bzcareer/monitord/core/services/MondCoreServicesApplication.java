package com.bzcareer.monitord.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bzcareer.monitord.core.model.Users;
import com.bzcareer.monitord.core.repository.UserRepository;

@ComponentScan(basePackages={"com.bzcareer.monitord.core.controller","com.bzcareer.monitord.core.model","com.bzcareer.monitord.core.repository"})
@SpringBootApplication
@EnableMongoRepositories(basePackages={"com.bzcareer.monitord.core.repository"})
public class MondCoreServicesApplication implements CommandLineRunner {

	@Autowired
	public UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MondCoreServicesApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		userRepository.deleteAll();
		userRepository.save(new Users("testing","testing123","QA"));
		userRepository.save(new Users("development","developing123","DEV"));
		userRepository.save(new Users("ui","ui123","UI"));
		System.out.println("Fetching All Users");
		System.out.println("-------------------");
		for (Users usr : userRepository.findAll()) {
			System.out.println("Users:"+usr);
		}
		System.out.println();
		System.out.println("Fetching All Users TESTING QA");
		System.out.println("-------------------");
		System.out.println(userRepository.findByUsername("testing"));
		System.out.println();
		System.out.println("Fetching All Users TESTING QA");
		System.out.println("-------------------");
		System.out.println(userRepository.findByUsername("ui"));

		
	}
	
}
