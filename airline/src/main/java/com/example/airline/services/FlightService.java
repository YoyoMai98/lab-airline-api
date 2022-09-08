package com.example.airline.services;

import com.example.airline.models.Flight;
import com.example.airline.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public Flight addNewFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).get();
    }
}
