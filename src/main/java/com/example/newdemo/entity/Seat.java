package com.example.newdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Random;

@Entity
@Table(name="seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seat_id")
    private int seatId;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name= "available")
    private boolean isAvailable;


    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "seat_class")
    private SeatClass seatClass;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    @JsonIgnore
    private Reservation reservation;

    //*************************seat generator **********************

    public static String seatGenerator() {

        StringBuilder seatNumber= new StringBuilder();
        Random random = new Random();

        int planeCapacity = 36;

        char[] seats = {'A', 'B', 'C', 'D', 'E', 'F'};


        // for 3-3 layout plane

        int randomInt = random.nextInt(6)+1;

        seatNumber.append(randomInt);
        seatNumber.append(seats[randomInt-1]);


        return seatNumber.toString();

    }
//******************************************************






    public Seat() {
    }

    public Seat(int seatId, String seatNumber, boolean isAvailable, Passengers passenger, User user, SeatClass seatClass, Reservation reservation) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
        this.seatClass = seatClass;
        this.reservation = reservation;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }




    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }



    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return seatId == seat.seatId && isAvailable == seat.isAvailable && Objects.equals(seatNumber, seat.seatNumber) && seatClass == seat.seatClass && Objects.equals(reservation, seat.reservation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatId, seatNumber, isAvailable, seatClass, reservation);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", seatNumber='" + seatNumber + '\'' +
                ", isAvailable=" + isAvailable +
                ", seatClass=" + seatClass +

                '}';
    }


}//seat class


