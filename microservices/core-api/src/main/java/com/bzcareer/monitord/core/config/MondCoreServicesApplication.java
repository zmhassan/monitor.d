package com.bzcareer.monitord.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import static springfox.documentation.builders.PathSelectors.regex;

import com.bzcareer.monitord.core.model.JobDAO;
import com.bzcareer.monitord.core.model.LogDAO;
import com.bzcareer.monitord.core.model.NodeDAO;
import com.bzcareer.monitord.core.model.NotificationDAO;
import com.bzcareer.monitord.core.model.UserDAO;
import com.bzcareer.monitord.core.services.JobService;
import com.bzcareer.monitord.core.services.LogService;
import com.bzcareer.monitord.core.services.NodeService;
import com.bzcareer.monitord.core.services.NotificationService;
import com.bzcareer.monitord.core.services.UserService;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = { "com.bzcareer.monitord.core.controller", "com.bzcareer.monitord.core.model",
		"com.bzcareer.monitord.core.repository", "com.bzcareer.monitord.core.services" })
@SpringBootApplication
@EnableSwagger2
@EnableMongoRepositories(basePackages = { "com.bzcareer.monitord.core.repository" })
public class MondCoreServicesApplication implements CommandLineRunner {

	@Autowired
	public UserService userService;
	@Autowired
	public NotificationService notifyService;
	@Autowired
	public JobService jobService;
	@Autowired
	public LogService logService;
	@Autowired
	public NodeService nodeService;

 	@Bean
	public Docket coreApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			        .groupName("coreapi")
			        .apiInfo(new ApiInfoBuilder().title("Monitor.D Core Api")
			        .description("Core api for integrating with monitor.d")
			        .contact("Zak Hassan <zak.hassan1010@gmail.com")
			        .version("1.0.0-SNAPSHOT")
			        .build())
			        .select()
				.apis(RequestHandlerSelectors.any())
				.paths(regex("/api.*")) 
				.build();

	}
 
	public static void main(String[] args) {
		SpringApplication.run(MondCoreServicesApplication.class, args);
	}

	/**
	 * 
	 * These method will initialize the database with mock data and let me serve
	 * up the ui with this data. To test ui visit:
	 * "http://localhost:8080/api/jobs" 
	 * "http://localhost:8080/api/logs"
	 * "http://localhost:8080/api/nodes" 
	 * "http://localhost:8080/api/alerts"
	 * "http://localhost:8080/api/users"
	 * 
	 * 
	 * curl -XDELETE 'http://localhost:8080/api/jobs/57103fb98484782bdec0f796'
	 * curl -XPUT localhost:8080/api/jobs/57103fb98484782bdec0f796 -d '{ "id":
	 * "57103fb98484782bdec0f796", "name": "apache-spark", "status": "SUCCESS",
	 * "start": "2014-10-20_20:12:00", "end": "2013-03-20_20:12:00", "type":
	 * "server-provision" }' -H "Content-Type: application/json"
	 * 
	 * curl -XPOST 'localhost:8080/api/jobs' -d '{ "name": "testing", "status":
	 * "success", "start": "2014-10-20_20:12:00", "end": "2013-03-20_20:12:00",
	 * "type": "server-provision" }' -H "Content-Type: application/json"
	 **/
	@Override
	public void run(String... arg0) throws Exception {

		userService.deleteAll();
		notifyService.deleteAll();
		jobService.deleteAll();
		logService.deleteAll();
		nodeService.deleteAll();

		nodeService.create(new NodeDAO("google.com", "10.0.0.1"));
		nodeService.create(new NodeDAO("yahoo.com", "10.3.4.6"));
		nodeService.create(new NodeDAO("bing.com", "10.2.3.4"));
		// Injecting mock data for setting up ui.
		userService.create(new UserDAO("testing", "testing123", "QA"));
		userService.create(new UserDAO("development", "developing123", "DEV"));
		userService.create(new UserDAO("ui", "ui123", "UI"));
		// Injecting mock data for setting up ui
		notifyService.create(new NotificationDAO("SMS", "johnsmith", "Service Outage"));
		notifyService.create(new NotificationDAO("Email", "jimmypickel", "Out of Memory"));
		notifyService.create(new NotificationDAO("Voicemail", "henrysimmons", "Out Of CPU"));

		logService.create(new LogDAO("fraud-service", "2014-10-20_20:12:00", "2013-03-20_20:12:00"));
		logService.create(new LogDAO("audit-service", "2013-12-20_20:42:00", "2014-03-20_20:12:00"));
		logService.create(new LogDAO("add-service", "2011-03-22_23:42:00", "2013-12-20_20:12:00"));

		jobService.create(
				new JobDAO("hadoop-1", "success", "2014-10-20_20:12:00", "2013-03-20_20:12:00", "server-provision"));
		jobService.create(
				new JobDAO("spark-3", "success", "2013-12-20_20:42:00", "2014-03-20_20:12:00", "server-provision"));
		jobService.create(
				new JobDAO("java-webapp", "success", "2011-03-22_23:42:00", "2013-12-20_20:12:00", "code-deploy"));

	}

}
