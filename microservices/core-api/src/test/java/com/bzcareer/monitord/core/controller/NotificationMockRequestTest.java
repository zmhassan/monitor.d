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

import com.bzcareer.monitord.core.model.NotificationDAO;
import com.bzcareer.monitord.core.services.NotificationService;

@RunWith(MockitoJUnitRunner.class)
public class NotificationMockRequestTest {

	 	@Mock
		private NotificationService service;
	    
	    private NotificationController controller;
	    
	    @Before
	    public void setUp(){
	    	controller = new NotificationController(service);
	    }
	    
	    @Test
	    public void shouldCreateItem() throws Exception {
	    	final NotificationDAO savedNotification = stubFactory();
	    	final NotificationDAO notification = createRandomItem();
	    	NotificationDAO createNotification = controller.createNotification(notification);
	    	verify(service, times(1)).create(notification);
	        assertEquals("Returned log should come from the service", createNotification, savedNotification);
	    }

		private NotificationDAO createRandomItem() {
			return new NotificationDAO("SMS", "johnsmith", "Service Outage");
		}

		private NotificationDAO stubFactory() {
			final NotificationDAO notification = new NotificationDAO();
			when(service.create(any(NotificationDAO.class))).thenReturn(notification);
			return notification;
		}
}
