package com.example.newdemo.service;

import com.example.newdemo.entity.Reservation;
import com.example.newdemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationService {
    List<Reservation> findAll();
    Optional<Reservation> findReservationById(String reservationId);

    void saveReservation(Reservation reservation);

   List<Reservation> getReservationByUsername(String username);
   void deleteReservationById(String id);


}
