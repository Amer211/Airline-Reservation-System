package com.example.newdemo.repository;

import com.example.newdemo.entity.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepository extends JpaRepository<Passengers,Integer> {
}
