package com.bzcareer.monitord.core.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bzcareer.monitord.core.model.UserDAO;
import com.bzcareer.monitord.core.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserMockRequestTest {

	 	@Mock
		private UserService service;
	    
	    private UserController controller;
	    
	    @Before
	    public void setUp(){
	    	controller = new UserController(service);
	    }
	    
	    @Test
	    public void shouldCreateItem() throws Exception {
	    	final UserDAO savedUser = stubFactory();
	    	final UserDAO user = createRandomItem();
	    	UserDAO createUser = controller.createUser(user);
	    	verify(service, times(1)).create(user);
	        assertEquals("Returned user should come from the service", createUser, savedUser);
	    }

		private UserDAO createRandomItem() {
			return new UserDAO("SMS", "johnsmith", "Service Outage");
		}

		private UserDAO stubFactory() {
			final UserDAO user = new UserDAO();
			when(service.create(any(UserDAO.class))).thenReturn(user);
			return user;
		}
}
