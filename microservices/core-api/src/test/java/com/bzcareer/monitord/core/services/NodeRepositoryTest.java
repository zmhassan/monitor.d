package com.bzcareer.monitord.core.services;

 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import com.bzcareer.monitord.core.config.MondCoreServicesApplication;
import com.bzcareer.monitord.core.model.NodeDAO;
import com.bzcareer.monitord.core.model.UserDAO;
import com.bzcareer.monitord.core.model.Users;
import com.bzcareer.monitord.core.repository.NodeRepository;
import com.bzcareer.monitord.core.repository.UserRepository;
//import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Provided unit test to check that the data was inserted properly.
 * 
 * @author Zak.Hassan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MondCoreServicesApplication.class)
@WebAppConfiguration
public class NodeRepositoryTest {

	@Autowired
	public NodeService service;

	@Before
	public void bootStrap() {
		service.deleteAll();
		service.create(new NodeDAO("google.com", "10.0.0.1"));
		service.create(new NodeDAO("yahoo.com", "10.3.4.6"));
		service.create(new NodeDAO("bing.com", "10.2.3.4"));
	}

	@Test
	public void nodeInsertedDataSuccessfully() {
		assertThat("User Data Access Code Inserted Data Successfully", service.findAll().size(), is(3));
	}

	@Test
	public void nodeNegativeScenarioTest() {
		assertThat("User Data Access Code Inserted Data Negative Scenario", service.findAll().size(), not(4));
	}

 	@Test
	public void checkingForWrongDataInserted() {
		NodeDAO nodeDAO = service.findAll().get(0);
		nodeDAO.setServerName("docker.com");
		service.update(nodeDAO);
		assertThat("Wrong Valid Data Is Correct", service.findById(nodeDAO.getId()).getServerName(),
				is("docker.com"));
	}

	@Test
	public void checkDeleteOperation() {
		service.delete(service.findAll().get(0));
		assertThat("User Data Access Code Inserted Data Successfully Deleted One", service.findAll().size(),
				is(2));
	}

	@Test
	public void checkDeleteAll() {
		service.deleteAll();
		assertThat("User Data Access Code Inserted Data Successfully Deleted All", service.findAll().size(),
				is(0));
	}
 

}
