package com.example.newdemo.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Entity
@Table(name="reservations")
public class Reservation {

    @Id
    @Column(name="reservation_id")
    private String reservationId;

    @ManyToOne
    @JoinColumn(name = "flight_number")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passengers passenger;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private SeatClass seatClass;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Column(name = "checked_in")
    private boolean isCheckedIn;

    //*****************Reservation Number Generator*************************

    public static String reservationNumberGenerator(){
        Random random = new Random();
        StringBuilder number= new StringBuilder();
        char[] letters = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','1','2'
                ,'3','4','5','6','7','8','9','0'
        };
        for(int i=0; i<6;i++){

            int index = random.nextInt(letters.length);
            char letter = letters[index];
            number.append(letter);

        }

        System.out.println("Reservation Number : "+number.toString());
        return number.toString();

    }


    //************************************************************


    public Reservation() {
    }

    public Reservation(String reservationId, Flight flight, Passengers passenger, User user, SeatClass seatClass, Seat seat, boolean isCheckedIn) {
        this.reservationId = reservationId;
        this.flight = flight;
        this.passenger = passenger;
        this.user = user;
        this.seatClass = seatClass;
        this.seat = seat;
        this.isCheckedIn = isCheckedIn;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passengers getPassenger() {
        return passenger;
    }

    public void setPassenger(Passengers passenger) {
        this.passenger = passenger;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        isCheckedIn = checkedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return isCheckedIn == that.isCheckedIn && Objects.equals(reservationId, that.reservationId) && Objects.equals(flight, that.flight) && Objects.equals(passenger, that.passenger) && Objects.equals(user, that.user) && seatClass == that.seatClass && Objects.equals(seat, that.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, flight, passenger, user, seatClass, seat, isCheckedIn);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", flight=" + flight +
                ", passenger=" + passenger +
                ", user=" + user +
                ", seatClass=" + seatClass +
                ", seat=" + seat +
                ", isCheckedIn=" + isCheckedIn +
                '}';
    }

    public void setFlight(Optional<Flight> byId) {

    }


}//class
