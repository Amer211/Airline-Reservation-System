package com.example.newdemo.service;

import com.example.newdemo.entity.Reservation;
import com.example.newdemo.entity.User;
import com.example.newdemo.repository.ReservationRepository;
import com.example.newdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{
    final private ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findReservationById(String reservationId) {
        System.out.println("Reservation ID :"+ reservationId);
        return reservationRepository.findById(reservationId);
    }


    @Override
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);

    }





    //find reservation by passenger username


    @Override
    public List<Reservation> getReservationByUsername(String username) {
        User user = userRepository.findByUsername(username);


        return reservationRepository.findByUser(user);
    }

    @Override
    public void deleteReservationById(String id) {
        reservationRepository.deleteById(id);

    }



}
