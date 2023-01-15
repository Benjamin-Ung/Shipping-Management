package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    //bean!
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
             Student mariam = new Student(
                    "Mariam",
                    21,
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student alex = new Student(
                    "Alex",
                    19,
                    "alex@gmail.com",
                    LocalDate.of(2001, Month.JANUARY, 24)
            );

            repository.saveAll(
                    List.of(mariam,alex)
            );
        };
    }
}
