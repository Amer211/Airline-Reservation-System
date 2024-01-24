package com.example.newdemo.repository;

import com.example.newdemo.entity.Reservation;
import com.example.newdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,String> {
    List<Reservation> findByUser(User user);
}
