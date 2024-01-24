package com.example.newdemo.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plane_id")
    private int planeId;



    @Column(name = "make")
    private String make;


    @Column(name = "model")
    private String model;



    @Column(name = "plane_capacity")
    private int planeCapacity;
    @Column(name = "seats_layout")
    private String planeSeatslayout;

    @OneToMany(mappedBy = "plane",cascade = CascadeType.ALL)
    private List<Flight> flights;

    public Plane() {
    }

    public Plane(int planeId, String make, String model, int planeCapacity, String planeSeatslayout, List<Flight> flights) {
        this.planeId = planeId;
        this.make = make;
        this.model = model;
        this.planeCapacity = planeCapacity;
        this.planeSeatslayout = planeSeatslayout;
        this.flights = flights;
    }

    public String getPlaneSeatslayout() {
        return planeSeatslayout;
    }

    public void setPlaneSeatslayout(String planeSeatslayout) {
        this.planeSeatslayout = planeSeatslayout;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPlaneCapacity() {
        return planeCapacity;
    }

    public void setPlaneCapacity(int planeCapacity) {
        this.planeCapacity = planeCapacity;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return planeId == plane.planeId && planeCapacity == plane.planeCapacity && Objects.equals(make, plane.make) && Objects.equals(model, plane.model) && Objects.equals(planeSeatslayout, plane.planeSeatslayout) && Objects.equals(flights, plane.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeId, make, model, planeCapacity, planeSeatslayout, flights);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "planeId=" + planeId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", planeCapacity=" + planeCapacity +
                ", planeSeatslayout='" + planeSeatslayout + '\'' +

                '}';
    }
}//class

