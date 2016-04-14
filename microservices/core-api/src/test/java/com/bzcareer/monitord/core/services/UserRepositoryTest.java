package com.bzcareer.monitord.core.services;

//import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bzcareer.monitord.core.config.MondCoreServicesApplication;
import com.bzcareer.monitord.core.model.UserDAO;

/**
 * Provided unit test to check that the data was inserted properly.
 * 
 * @author Zak.Hassan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MondCoreServicesApplication.class)
@WebAppConfiguration
public class UserRepositoryTest {

	@Autowired
	public UserService userRepository;

	@Before
	public void bootStrap() {
		userRepository.deleteAll();
		userRepository.create(new UserDAO("testing", "testing123", "QA"));
		userRepository.create(new UserDAO("development", "developing123", "DEV"));
		userRepository.create(new UserDAO("ui", "ui123", "UI"));
	}

	@Test
	public void userInsertedDataSuccessfully() {
		assertThat("User Data Access Code Inserted Data Successfully", userRepository.findAll().size(), is(3));
	}

	@Test
	public void userNegativeScenarioTest() {
		assertThat("User Data Access Code Inserted Data Negative Scenario", userRepository.findAll().size(), not(4));
	}

	@Test
	public void checkingForWrongDataInserted() {
		assertThat("Wrong Valid Data Is Correct", userRepository.findByUsername("FAILINGTeam"),
				is(nullValue(UserDAO.class)));
	}

	@Test
	public void checkDeleteOperation() {
		userRepository.delete(userRepository.findByUsername("ui"));
		assertThat("User Data Access Code Inserted Data Successfully Deleted One", userRepository.findAll().size(),
				is(2));
	}

	@Test
	public void checkDeleteAll() {
		userRepository.deleteAll();
		assertThat("User Data Access Code Inserted Data Successfully Deleted All", userRepository.findAll().size(),
				is(0));
	}

	@Test
	public void checkPutOne() {
		UserDAO user = userRepository.findByUsername("ui");
		user.setTeam("numberOne");
		userRepository.update(user);
		assertThat("User Data Access Code Inserted Data Successfully Put One", userRepository.findAll().size(), is(3));
		assertThat("User Data Access Code Inserted Data Successfully Put One",
				userRepository.findByUsername("ui").getTeam(), is("numberOne"));
	}

}
