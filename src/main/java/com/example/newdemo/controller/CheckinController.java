package com.example.newdemo.controller;

import com.example.newdemo.entity.Reservation;
import com.example.newdemo.entity.Seat;
import com.example.newdemo.security.CustomUserDetails;
import com.example.newdemo.service.FlightService;
import com.example.newdemo.service.ReservationService;
import com.example.newdemo.service.SeatService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class CheckinController {

    private final ReservationService reservationService;
    private final FlightService flightService;

    private final SeatService seatService;

    public CheckinController(ReservationService reservationService, FlightService flightService, SeatService seatService) {
        this.reservationService = reservationService;
        this.flightService = flightService;

        this.seatService = seatService;
    }


    @GetMapping("/user/check-in")
    public String showCheckInForm(Model model, Authentication authentication,
                                  @RequestParam("reservationId") String reservationId){


        if(authentication!=null && authentication.isAuthenticated()){
            CustomUserDetails customUserDetails= (CustomUserDetails) authentication
                    .getPrincipal();
            model.addAttribute("user",customUserDetails);


            Optional<Reservation> reservation = reservationService
                    .findReservationById(reservationId);
            if(reservation.isPresent()){
                model.addAttribute("reservation", reservation.get());
                model.addAttribute("flight",reservation.get().getFlight());



            }else{
                System.out.println("Reservation not found.");
            }


        }//if user found
        else{
            System.out.println("user not found.");
        }
        return "check-in-form";
    }

     //***********************************************************************
    // perform check-in



    @PostMapping("/user/perform-check-in")
    public String performCheckIn(Authentication authentication,Model model,
                                 @RequestParam("reservationId") String reservationId){

        if(authentication!=null && authentication.isAuthenticated()){
            CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
            model.addAttribute("user",customUserDetails);

             //reservation
            Optional<Reservation> reservation = reservationService
                    .findReservationById(reservationId);

            if(reservation.isPresent()){
                model.addAttribute("reservation",reservation.get());
                reservation.get().setCheckedIn(true); //change checked-in to true


                String seatString= Seat.seatGenerator();

                    Seat seat = new Seat();
                    seat.setSeatNumber(seatString);
                    seat.setAvailable(false);
                    seat.setReservation(reservation.get());
                    seat.setSeatClass(reservation.get().getSeatClass());

                    reservation.get().setSeat(seat);
                    seatService.saveSeat(seat);




            }//if reservation present
            else {
                System.out.println("Reservation not found.");
            }


        }else{
            System.out.println("log in to check-in");
        }

        //creating QR Code **********************************

       //  byte[] qrCodebytes = generateQRcode("check in");





        return "check-in-confirmation";
    }





}//class
