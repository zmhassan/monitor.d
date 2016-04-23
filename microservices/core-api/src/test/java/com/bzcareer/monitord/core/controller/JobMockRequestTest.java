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

import com.bzcareer.monitord.core.model.JobDAO;
import com.bzcareer.monitord.core.services.JobService;

@RunWith(MockitoJUnitRunner.class)
public class JobMockRequestTest {

	 	@Mock
		private JobService service;
	    
	    private JobController controller;
	    
	    @Before
	    public void setUp(){
	    	controller = new JobController(service);
	    }
	    
	    @Test
	    public void shouldCreateJob() throws Exception {
	    	
	    	final JobDAO savedJob = stubFactory();
	    	final JobDAO job = createRandomItem();
	    	JobDAO createJob = controller.createJob(job);
	    	verify(service, times(1)).create(job);
	        assertEquals("Returned job should come from the service", createJob, savedJob);

	    }

		private JobDAO createRandomItem() {
			return new JobDAO("hadoop-1", "success", "2014-10-20_20:12:00", "2013-03-20_20:12:00", "server-provision");
		}

		private JobDAO stubFactory() {
			final JobDAO job = new JobDAO();
			when(service.create(any(JobDAO.class))).thenReturn(job);
			return job;
		}
	
	
}
