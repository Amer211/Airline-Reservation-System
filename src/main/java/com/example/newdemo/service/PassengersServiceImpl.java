package com.example.newdemo.service;

import com.example.newdemo.entity.Passengers;
import com.example.newdemo.repository.PassengersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengersServiceImpl implements PassengersService{
    private final PassengersRepository passengersRepository;

    public PassengersServiceImpl(PassengersRepository passengersRepository) {
        this.passengersRepository = passengersRepository;
    }


    @Override
    public List<Passengers> findAll() {
        return passengersRepository.findAll();
    }

    @Override
    public Passengers savePassenger(Passengers passenger) {
        passengersRepository.save(passenger);
        return passenger;
    }
}
