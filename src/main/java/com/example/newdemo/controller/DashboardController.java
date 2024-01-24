package com.example.newdemo.controller;

import com.example.newdemo.entity.Reservation;
import com.example.newdemo.service.ReservationService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {
   private final ReservationService reservationService;

    public DashboardController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/account")
    public String showDashboard(Model model,Authentication authentication){

        String username = authentication.getName();
        List<Reservation> reservations = reservationService
                .getReservationByUsername(username);
        model.addAttribute("reservations", reservations);


        return "account";
    }
}
