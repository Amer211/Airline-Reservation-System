package com.example.newdemo.service;

import com.example.newdemo.entity.Destination;
import com.example.newdemo.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository destinationRepository;

    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public List<Destination> getDestinations() {

        return destinationRepository.findAll();
    }

    @Override
    public void saveDestination(Destination destination) {
        destinationRepository.save(destination);
        System.out.println(destination.getDestinationName()+" was added.");

    }
}
