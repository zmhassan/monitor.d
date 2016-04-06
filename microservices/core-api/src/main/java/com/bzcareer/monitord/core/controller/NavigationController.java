package com.bzcareer.monitord.core.controller;

 import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/nav")
public class NavigationController {

	@RequestMapping(method=RequestMethod.GET)
	public Map<String,String> getNav(){
	 return new HashMap<String,String>(){{
			put("Dashboard", "/dash"); 
			put("Network", "/network"); 
			put("CPU", "/cpu"); 
			put("Hosts","/hosts");
			put("Services","/svc");
	 }};
			 
	}
	 

}
