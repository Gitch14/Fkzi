package com.example.fkzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.fkzi")
public class FkziApplication {

    public static void main(String[] args) {
        SpringApplication.run(FkziApplication.class, args);
    }

}
