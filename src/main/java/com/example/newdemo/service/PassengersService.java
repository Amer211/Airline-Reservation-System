package com.example.newdemo.service;

import com.example.newdemo.entity.Passengers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengersService {

    List<Passengers> findAll();

    Passengers savePassenger(Passengers passengers);



}
