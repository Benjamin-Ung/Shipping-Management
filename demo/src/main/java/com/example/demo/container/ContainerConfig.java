package com.example.demo.container;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ContainerConfig {
    //bean!
    @Bean
    CommandLineRunner commandLineRunner(ContainerRepository repository) {
        return args -> {
             Container mariam = new Container(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    "LA",
                     "San Francisco"
            );

            Container alex = new Container(
                    "Alex",
                    "alex@gmail.com",
                    "San Francisco",
                    "LA"
            );

            repository.saveAll(
                    List.of(mariam,alex)
            );
        };
    }
}
