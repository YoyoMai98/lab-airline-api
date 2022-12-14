package com.example.airline.controllers;

import com.example.airline.models.Passenger;
import com.example.airline.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        List<Passenger> passengers = passengerService.getAllPassengers();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id){
        Passenger passenger = passengerService.getPassengerById(id);
        return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Passenger> addNewPassenger(@RequestBody Passenger passenger){
        Passenger savedPassenger = passengerService.addNewPassenger(passenger);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }
}
