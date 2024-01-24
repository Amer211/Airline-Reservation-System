package com.example.newdemo.service;

import com.example.newdemo.entity.Flight;
import com.example.newdemo.entity.Reservation;
import com.example.newdemo.entity.Seat;
import com.example.newdemo.repository.FlightRepository;
import com.example.newdemo.repository.ReservationRepository;
import com.example.newdemo.repository.SeatRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService{
    private final SeatRepository seatRepository;
    private final FlightRepository flightRepository;

    private final ReservationRepository reservationRepository;
    public SeatServiceImpl(SeatRepository seatRepository, FlightRepository flightRepository, ReservationRepository reservationRepository) {
        this.seatRepository = seatRepository;
        this.flightRepository = flightRepository;
        this.reservationRepository = reservationRepository;
    }


    @Override
    public void saveSeat(Seat seat) {
        seatRepository.save(seat);
        System.out.println(seat +" was saved.");

    }

    @Override
    public Optional<Seat> findSeatById(int id) {
        return seatRepository.findById(id);
    }










}
