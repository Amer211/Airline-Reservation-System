package com.example.newdemo.controller;

import com.example.newdemo.entity.Reservation;
import com.example.newdemo.entity.User;
import com.example.newdemo.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //user profile
    @GetMapping("/user/profile")
    public String showUserProfile(Model model, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        if(user!=null){
            model.addAttribute("user",user);
            return "user-profile";
        }else{
            return "User Not Found.";
        }
    }

    //user reservations
    @GetMapping("/user/reservations")
    public String userReservations(Model model, Authentication authentication){
        String username = authentication.getName();
        List<Reservation> reservations = userService.getReservationsByUsername(username);

        return "my-reservations";
    }










}//class
