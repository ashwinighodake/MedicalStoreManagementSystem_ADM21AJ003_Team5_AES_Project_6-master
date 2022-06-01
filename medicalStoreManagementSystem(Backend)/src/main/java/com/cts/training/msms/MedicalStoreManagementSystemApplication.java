package com.cts.training.msms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicalStoreManagementSystemApplication {
	
	private final static Logger LOGGER = LogManager.getLogger(MedicalStoreManagementSystemApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MedicalStoreManagementSystemApplication.class, args);
		LOGGER.info("Info Message Logged !!!..You are inside application. Now you can access modules");
        
	}

}
