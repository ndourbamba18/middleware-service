package com.ndourcodeur.departmentbackendservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author NdourCodeur
 * @since 23/02/2023
 * @version v1.0.0
 */
@SpringBootApplication
@EnableFeignClients
public class DepartmentBackendServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(DepartmentBackendServiceApplication.class, args);
		System.out.println("Server started.....");
	}

}
