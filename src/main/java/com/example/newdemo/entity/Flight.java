package com.example.newdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.security.SecureRandom;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity

@Table(name="flights")

public class Flight {
    @Id
    @Column(name="flight_number")
    private String flightNumber;

    @Column(name="departure")
    private String departure;

    @Column(name="arrival")
    private String arrival;

    @Column(name = "departure_date")
    private LocalDate departureDate;


    @Column(name="departure_time")
    private LocalTime departureTime;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;


//************** flight number generator*****************
public static String generateFlightNumber() {
    StringBuilder number = new StringBuilder();

    number.append("AK");


    for(int i=0;i<6;i++) {
        SecureRandom random = new SecureRandom();
        int x=random.nextInt(9);
        number.append(x);
    }

    String flightNumber =number.toString();

    System.out.println("Flight Number : " +flightNumber);


    return flightNumber;
     }
     //***************************************************************

    //**************** format time




    //***************************************************************

    public Flight() {
    }

    public Flight(String flightNumber, String departure, String arrival,
                  LocalDate departureDate, LocalTime departureTime, Plane plane) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.plane = plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(departure, flight.departure) && Objects.equals(arrival, flight.arrival) && Objects.equals(departureDate, flight.departureDate) && Objects.equals(departureTime, flight.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, departure, arrival, departureDate, departureTime);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +

                '}';
    }
}
