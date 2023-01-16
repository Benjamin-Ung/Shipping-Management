package com.example.demo.container;

import jakarta.persistence.*;

@Entity
@Table
public class Container{
    @Id
    @SequenceGenerator(
            name = "container sequence",
            sequenceName = "container_sequence",
            allocationSize = 1
   )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "container sequence"
    )
    private Long id;
    private String vendor;
    private String email;
    private String destination;

    public Container() {
    }

    public Container(String vendor, String email, String destination) {
        this.vendor = vendor;
        this.email = email;
        this.destination = destination;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", vendor='" + vendor + '\'' +
                ", email='" + email + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
