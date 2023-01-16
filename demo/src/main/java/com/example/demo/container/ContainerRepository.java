package com.example.demo.container;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

    //Select * from student where email = email
    //@Query("SELECT s FROM Container s WHERE s.email = ?1")
    //Optional<Container> findContainerByEmail(String email);
}
