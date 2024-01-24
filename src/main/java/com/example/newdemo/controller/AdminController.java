package com.example.newdemo.controller;

import com.example.newdemo.entity.Plane;
import com.example.newdemo.entity.User;
import com.example.newdemo.service.PlaneService;
import com.example.newdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    private final UserService userService;
    private final PlaneService planeService;
    private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    public AdminController(UserService userService, PlaneService planeService) {
        this.userService = userService;
        this.planeService = planeService;
    }


    @RequestMapping("/createAdmin")
    @ResponseBody
    public String addNewAdmin(@RequestParam("username") String username) {
        if(userService.usernameExists(username)){
            return "Admin already exists!";
        }

        userService.addAdmin(username);

        return "Admin created.";
    }

    @GetMapping("/manager/add")
    public String showAddManagerForm(Model model,User user){
        model.addAttribute("user",new User());
        return "add-manager-form";
    }
    @PostMapping("/manager/save")
    public String saveManager(@ModelAttribute("user") User user){
        userService.saveManager(user);
        return "redirect:/Home";
    }

    // see All users
    @GetMapping("/admin/users")
    public String showUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users-list";
    }


//************************      add plane     *****************************************
    @GetMapping("/admin/addPlane")
    public String showAddPlaneForm(Model model){

        model.addAttribute("plane",new Plane());
        return "add-plane-form";
    }

    @PostMapping("/admin/savePlane")
    public String savePlane(@ModelAttribute("plane") Plane plane){
        planeService.savePlane(plane);
        return "redirect:/Home";
    }





}//admin class
