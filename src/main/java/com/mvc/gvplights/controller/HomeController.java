package com.mvc.gvplights.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
  
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String index() {
		log.info("Entered Controller :: HomeController :: index()");
		log.debug("checking");
		return "welcome";
	}

}
