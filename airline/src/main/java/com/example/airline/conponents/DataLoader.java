package com.example.airline.conponents;

import com.example.airline.models.Flight;
import com.example.airline.models.Passenger;
import com.example.airline.repositories.FlightRepository;
import com.example.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        LocalDate date1 = LocalDate.of(2022,10,1);
        LocalDate date2 = LocalDate.of(2022,9,28);
        LocalDate date3 = LocalDate.of(2022, 12,13);
        LocalTime time1 = LocalTime.of(15,30);
        LocalTime time2 = LocalTime.of(9,20);
        LocalTime time3 = LocalTime.of(12,30);

        Flight flight1 = new Flight("Hong Kong", 3, date1, time1);
        Flight flight2 = new Flight("Tuscany", 2, date2, time2);
        Flight flight3 = new Flight("Seattle", 2, date3, time3);

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        Passenger passenger1 = new Passenger("Temperance Brennan", "123456789");
        Passenger passenger2 = new Passenger("Aaron Hotchner", "638291038");
        Passenger passenger3 = new Passenger("Frodo Baggins", "738290983");
        Passenger passenger4 = new Passenger("Meredith Grey", "872938162");

        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);
        passengerRepository.save(passenger3);
        passengerRepository.save(passenger4);
    }
}
