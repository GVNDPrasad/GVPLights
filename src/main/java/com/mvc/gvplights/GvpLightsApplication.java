package com.mvc.gvplights;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GvpLightsApplication {
    
	private static final Logger log = LoggerFactory.getLogger(GvpLightsApplication.class);

	public static void main(String[] args) {
		log.info("Entered GvpLightsApplication :: main()");
		SpringApplication.run(GvpLightsApplication.class, args);
	}

}
