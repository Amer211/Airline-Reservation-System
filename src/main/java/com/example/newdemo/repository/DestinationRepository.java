package com.example.newdemo.repository;

import com.example.newdemo.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,Integer> {
}
