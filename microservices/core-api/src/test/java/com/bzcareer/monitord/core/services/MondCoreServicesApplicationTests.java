package com.bzcareer.monitord.core.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bzcareer.monitord.core.config.MondCoreServicesApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MondCoreServicesApplication.class)
@WebAppConfiguration
public class MondCoreServicesApplicationTests {
 
	@Test
	public void contextLoads() {
		// Context is loaded !!
	}
 
}
