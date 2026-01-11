// Importing required modules and packages

package com.example.jspdemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Tells Spring Boot this is the main application class
@SpringBootApplication
// Tells Spring to look for components in the specified package
@ComponentScan("com.example.jspdemo")

public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
