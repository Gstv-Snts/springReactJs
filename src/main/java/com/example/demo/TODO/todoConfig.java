package com.example.demo.TODO;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class todoConfig {
    @Bean
    CommandLineRunner CommandLineRunner(todoRepository repository){
        return args -> {
        };
    }
}
