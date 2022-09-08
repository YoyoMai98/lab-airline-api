package com.example.airline.controllers;

import com.example.airline.models.Flight;
import com.example.airline.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFights(){
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        Flight flight = flightService.getFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
         Flight savedFlight = flightService.addNewFlight(flight);
         return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }
}