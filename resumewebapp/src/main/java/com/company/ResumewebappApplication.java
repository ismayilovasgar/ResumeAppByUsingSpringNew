package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
//@SpringBootApplication(scanBasePackages = {"com.company", "com.company.resumewebapp"})
public class ResumewebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumewebappApplication.class, args);
    }
}
