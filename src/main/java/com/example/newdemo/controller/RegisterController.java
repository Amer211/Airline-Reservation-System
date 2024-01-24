package com.example.newdemo.controller;

import com.example.newdemo.entity.Passengers;
import com.example.newdemo.entity.User;
import com.example.newdemo.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
   private final UserServiceImpl userService;

    public RegisterController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new Passengers());
        return "register-form";
    }
     @PostMapping("/register/save")
    public String register(@ModelAttribute("user")User user){
        userService.saveUser(user);
        return "registration-success";
     }




}
