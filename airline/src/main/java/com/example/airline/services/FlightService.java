package com.example.airline.services;

import com.example.airline.models.Flight;
import com.example.airline.models.Passenger;
import com.example.airline.repositories.FlightRepository;
import com.example.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public Flight addNewFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight addPassengerToFlight(Long flightId, Long passengerId){
        Flight flight = flightRepository.findById(flightId).get();
        Passenger passenger = passengerRepository.findById(passengerId).get();
        List<Passenger> passengers = flight.getPassengers();
        if(passengers.size() < flight.getCapacity()){
            passengers.add(passenger);
            flight.setPassengers(passengers);
            flightRepository.save(flight);
        }
        return flight;
    }

    public void cancelFlightById(long id) {
        Flight flight = flightRepository.findById(id).get();
        flightRepository.delete(flight);
    }

    public List<Flight> getAllGamesByDestination(String destination){
        return flightRepository.findByDestination(destination);
    }
}
