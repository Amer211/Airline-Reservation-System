package com.example.newdemo.service;

import com.example.newdemo.entity.Reservation;
import com.example.newdemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> findById(int id);
    User findByUsername(String username);

    void saveUser(User user);


    //for Admin


    void addAdmin(String username);

    boolean usernameExists(String username);

    void saveManager(User user);

    List<Reservation> getReservationsByUsername(String username);

    List<User> getAllUsers();

    Optional<Reservation> getReservationById(String reservationId);
}
