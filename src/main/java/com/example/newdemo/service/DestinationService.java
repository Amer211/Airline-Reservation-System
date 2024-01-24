package com.example.newdemo.service;

import com.example.newdemo.entity.Destination;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DestinationService {
    List<Destination> getDestinations();
    void saveDestination(Destination destination);

}
