package com.example.newdemo.repository;

import com.example.newdemo.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane,Integer> {
}
