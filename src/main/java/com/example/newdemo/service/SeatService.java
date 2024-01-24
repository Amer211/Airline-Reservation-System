package com.example.newdemo.service;

import com.example.newdemo.entity.Seat;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SeatService {

    void saveSeat(Seat seat);

    Optional<Seat> findSeatById(int id);



}
