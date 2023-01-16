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
    private String currentLocation;
    private String destination;

    public Container() {
    }

    public Container(Long id, String vendor, String email, String currentLocation, String destination) {
        this.id = id;
        this.vendor = vendor;
        this.email = email;
        this.currentLocation = currentLocation;
        this.destination = destination;
    }

    public Container(String vendor, String email, String currentLocation, String destination) {
        this.vendor = vendor;
        this.email = email;
        this.currentLocation = currentLocation;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean getStatus() {
        return currentLocation.equals(destination);
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", vendor='" + vendor + '\'' +
                ", email='" + email + '\'' +
                ", destination='" + destination + '\'' +
                ", status ='" + getStatus() +
                '}';
    }
}
