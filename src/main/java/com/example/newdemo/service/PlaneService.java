package com.example.newdemo.service;

import com.example.newdemo.entity.Plane;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlaneService {
    List<Plane> getPlanes();

    Optional<Plane> findPlaneById(int id);
    void savePlane(Plane plane);

    void deletePlaneById(int id);

}
