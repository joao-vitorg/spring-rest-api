package com.example.springrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringRestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringRestApiApplication.class, args);
    }
}
