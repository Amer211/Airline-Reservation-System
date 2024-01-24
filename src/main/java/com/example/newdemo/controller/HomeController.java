package com.example.newdemo.controller;

import com.example.newdemo.security.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/Home", "/"})
    public String home(Model model,Authentication authentication){
        if(authentication!=null && authentication.isAuthenticated()){
            CustomUserDetails userDetails= (CustomUserDetails) authentication.getPrincipal();

        }

        return "Home";
    }


















}//class

