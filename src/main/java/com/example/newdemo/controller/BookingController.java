package com.example.newdemo.controller;

import com.example.newdemo.entity.Flight;
import com.example.newdemo.entity.Passengers;
import com.example.newdemo.entity.Reservation;
import com.example.newdemo.entity.SeatClass;
import com.example.newdemo.security.CustomUserDetails;
import com.example.newdemo.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class BookingController {

    private final FlightServiceImpl flightService;
    final private ReservationServiceImpl reservationService;
    private final PassengersServiceImpl passengersService;
    private final UserService userService;
    private final PlaneService planeService;


    public BookingController(FlightServiceImpl flightService, ReservationServiceImpl reservationService, PassengersServiceImpl passengersService, UserService userService, PlaneService planeService) {
        this.flightService = flightService;
        this.reservationService = reservationService;
        this.passengersService = passengersService;
        this.userService = userService;
        this.planeService = planeService;
    }


    @GetMapping("/bookFlight")
    public String bookFlight(@RequestParam("flightNumber") String flightNumber,
                             Authentication authentication,
                             Model model){

        if(authentication!=null && authentication.isAuthenticated()){
            CustomUserDetails userDetails =
                    (CustomUserDetails) authentication.getPrincipal();

            model.addAttribute("user",userDetails);

        }else {
            model.addAttribute("passenger", new Passengers());
        }
        Optional<Flight> flight = flightService.findById(flightNumber);
        flight.ifPresent(value -> model.addAttribute("flight", value));

        return "booking";


    }

    //*********************** confirm reservation***********************
    @PostMapping("/submitBooking")
    public String confirmReservation(@ModelAttribute("passenger") Passengers passenger,
                                     @ModelAttribute("reservation") Reservation reservation,
                                     @RequestParam("flightNumber") String flightNumber,
                                     @RequestParam("seatClass") SeatClass seatClass,
                                     Authentication authentication,
                                     Model model){


        Optional<Flight> newFlight = flightService.findById(flightNumber);
        if (newFlight.isPresent()) {
            model.addAttribute("flight",newFlight.get());
            reservation.setFlight(newFlight.get());

        }else{
            System.out.println("Flight Not found");
        }

        if(authentication!=null && authentication.isAuthenticated()){

            CustomUserDetails customUserDetails=
                    (CustomUserDetails) authentication.getPrincipal();

            reservation.setUser(userService.findByUsername(customUserDetails.getUsername()));
            model.addAttribute("user",userService.findByUsername(customUserDetails.getUsername()));
            reservation.setReservationId(Reservation.reservationNumberGenerator());
            reservation.setSeatClass(seatClass);
            reservation.setPassenger(null);// to revise





        }else {
            reservation.setPassenger(passengersService.savePassenger(passenger));
            reservation.setReservationId(Reservation.reservationNumberGenerator());
            reservation.setSeatClass(seatClass);
            reservation.setUser(null);
            model.addAttribute("passenger",passengersService.savePassenger(passenger));
        }


        reservationService.saveReservation(reservation);
        return "confirmation";

    }

    //***************search reservation******************
    @GetMapping("/searchReservation")
    public String searchReservationById() {

        return "search-reservation";
    }

    @GetMapping("/searchReservation/myReservation")
    public String showReservations(Model model, Authentication authentication) {
        String username = authentication.getName();
        List<Reservation> reservations = reservationService
                .getReservationByUsername(username);

        model.addAttribute("reservations", reservations);
        return "my-reservations";
        }

    @GetMapping("/findReservation")
    public String findReservation(@RequestParam("id") String reservationId,
                                  Model model){
        Optional<Reservation> reservation = reservationService.findReservationById(reservationId);
        if(reservation.isPresent()){
            model.addAttribute("reservation",reservation.get());
        }else{
            model.addAttribute("errorMessage", "Reservation not found with the provided ID.");

        }
        return "search-reservation-result";
    }

    //**************delete/cancel reservation******************
    @GetMapping("/cancelReservation")
    public String deleteReservationById(@RequestParam("id") String id){
        reservationService.deleteReservationById(id);
        System.out.println("Reservation ID :"+ id+" was cancelled.");
        return "reservation-cancelled";
    }







}//class
