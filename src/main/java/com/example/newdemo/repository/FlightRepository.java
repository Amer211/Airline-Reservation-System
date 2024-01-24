package com.example.newdemo.repository;

import com.example.newdemo.entity.Destination;
import com.example.newdemo.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {

    //** custom query to search for flights
    @Query("SELECT f FROM Flight f WHERE f.departure = :departure AND f.arrival = :arrival")
    List<Flight> findByDepartureArrival(String departure, String arrival);
}

