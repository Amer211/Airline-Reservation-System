package com.example.newdemo.service;

import com.example.newdemo.entity.Flight;
import com.example.newdemo.repository.DestinationRepository;
import com.example.newdemo.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService{
    private final FlightRepository flightRepository;
    private final DestinationRepository destinationRepository;

    public FlightServiceImpl(FlightRepository flightRepository, DestinationRepository destinationRepository) {

        this.flightRepository = flightRepository;
        this.destinationRepository = destinationRepository;
    }



    //*************find all flights***************
    @Override
    public List<Flight> findFlights() {

        return flightRepository.findAll();
    }

    //********search by id
    @Override
    public Optional<Flight> findById(String flightNumber) {

        return flightRepository.findById(flightNumber);
    }


    //*****************save a new flight*****************
    @Override
    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }



    //*****************find flights by destination*****************
    @Override
    public List<Flight> findByDepartureArrival(String departure, String arrival) {
        return flightRepository.findByDepartureArrival(departure,arrival);
    }


}
