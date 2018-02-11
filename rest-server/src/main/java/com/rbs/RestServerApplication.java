package com.rbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.rbs.repository")
@EntityScan(basePackages = "com.rbs.entity")
public class RestServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestServerApplication.class, args);
    }
}
