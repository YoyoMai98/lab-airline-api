package com.example.airline.controllers;

import com.example.airline.models.Flight;
import com.example.airline.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFights(@RequestParam Optional<String> destination){
        List<Flight> flights;
        if(destination.isPresent()){
            flights = flightService.getAllGamesByDestination(destination.get());
        }else{
            flights = flightService.getAllFlights();
        }
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

    @PatchMapping("/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(@PathVariable long id, @RequestParam long passengerId){
        Flight flight = flightService.addPassengerToFlight(id, passengerId);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity cancelFlightById(@PathVariable long id){
        flightService.cancelFlightById(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
