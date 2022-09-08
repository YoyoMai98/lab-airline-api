package com.example.airline.services;

import com.example.airline.models.Flight;
import com.example.airline.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public Flight addNewFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }
}
