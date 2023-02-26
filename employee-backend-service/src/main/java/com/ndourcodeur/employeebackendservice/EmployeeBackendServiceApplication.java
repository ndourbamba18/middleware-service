package com.ndourcodeur.employeebackendservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author NdourCodeur
 * @since 23/02/2023
 * @version v1.0.0
 */
@SpringBootApplication
public class EmployeeBackendServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeBackendServiceApplication.class, args);
		System.out.println("Server started.....");
	}

}
