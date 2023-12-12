package com.ibuc.bookmyservice.workermanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.utility.commons.utilitycommons.*")
@SpringBootApplication
public class WorkermanagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkermanagementServiceApplication.class, args);
	}

}
