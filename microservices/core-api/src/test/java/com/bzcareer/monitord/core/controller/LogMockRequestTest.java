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

import com.bzcareer.monitord.core.model.LogDAO;
import com.bzcareer.monitord.core.services.LogService;

@RunWith(MockitoJUnitRunner.class)
public class LogMockRequestTest {

	 	@Mock
		private LogService service;
	    
	    private LogController controller;
	    
	    @Before
	    public void setUp(){
	    	controller = new LogController(service);
	    }
	    
	    @Test
	    public void shouldCreateLog() throws Exception {
	    	
	    	final LogDAO savedLog = stubFactory();
	    	final LogDAO log = createRandomItem();
	    	LogDAO createLog = controller.createLog(log);
	    	verify(service, times(1)).create(log);
	        assertEquals("Returned log should come from the service", createLog, savedLog);

	    }

		private LogDAO createRandomItem() {
			return new LogDAO("fraud-service", "2014-10-20_20:12:00", "2013-03-20_20:12:00");
		}

		private LogDAO stubFactory() {
			final LogDAO log = new LogDAO();
			when(service.create(any(LogDAO.class))).thenReturn(log);
			return log;
		}
	
	
}
