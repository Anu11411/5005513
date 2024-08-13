package com.example.empMgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeManagementAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementAppApplication.class, args);
    }
}
