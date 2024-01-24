package com.example.newdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.NumberFormat;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="passengers")

public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="passenger_id")
    private int passengerId;

    @Pattern(regexp = "[A-Za-z\\s]+",message = "letters only!")
    @Column(name="first_name")
    private String firstName;

    @Pattern(regexp = "[A-Za-z\\s]+",message = "letters only!")
    @Column(name="last_name")
    private String lastName;

    @Column(name="date_of_birth")
    private Date dateOfBirth;


    @NumberFormat
    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="address")
    private String address;
    @OneToMany(mappedBy = "passenger" , cascade = CascadeType.ALL)
    List<Reservation> reservations= new ArrayList<>();


    public Passengers() {
    }

    public Passengers(String firstName, String lastName, Date dateOfBirth, String phoneNumber, String address) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passengers that = (Passengers) o;
        return passengerId == that.passengerId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, firstName, lastName, dateOfBirth, phoneNumber, address);
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "passengerId=" + passengerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}//class

