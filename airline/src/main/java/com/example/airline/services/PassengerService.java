package com.example.airline.services;

import com.example.airline.models.Passenger;
import com.example.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger addNewPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}
