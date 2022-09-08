package com.example.airline.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String destination;

    @Column
    private int capacity;

    @Column(name = "departure_date")
    private String departureDate;

    @Column(name = "departure_time")
    private String departureTime;

    @ManyToMany
    @JoinTable(
            name = "flights_passengers",
            joinColumns = {@JoinColumn(name = "flight_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "passenger_id", nullable = false)}
    )
    @JsonIgnoreProperties({"flights"})
    private List<Passenger> passengers;

    public Flight(String destination, int capacity, String departureDate, String departureTime) {
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();
    }

    public Flight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
