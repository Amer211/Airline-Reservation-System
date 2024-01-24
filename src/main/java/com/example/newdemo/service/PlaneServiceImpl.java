package com.example.newdemo.service;

import com.example.newdemo.entity.Plane;
import com.example.newdemo.repository.PlaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneServiceImpl implements PlaneService{
    private final PlaneRepository planeRepository;


    public PlaneServiceImpl(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }


    @Override
    public List<Plane> getPlanes() {
        return planeRepository.findAll();
    }

    @Override
    public Optional<Plane> findPlaneById(int id) {
        return planeRepository.findById(id);
    }

    @Override
    public void savePlane(Plane plane) {
        planeRepository.save(plane);
        System.out.println(plane.getMake()+plane.getModel()  +" was saved");

    }

    @Override
    public void deletePlaneById(int id) {
        planeRepository.deleteById(id);
        if(planeRepository.findById(id).isPresent()){
            System.out.println(planeRepository.findById(id).get().getMake()
                    +planeRepository.findById(id).get().getModel()+" was deleted.");
        }


    }
}//class
