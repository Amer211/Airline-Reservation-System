package com.example.newdemo.service;

import com.example.newdemo.entity.Flight;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FlightService {
    List<Flight> findFlights();

    Optional<Flight> findById(String flightNumber);


    void saveFlight(Flight flight);


    List<Flight> findByDepartureArrival(String departure, String arrival);
}
