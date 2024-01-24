package com.example.newdemo.controller;

import com.example.newdemo.entity.Destination;
import com.example.newdemo.service.DestinationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DestinationController {
    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    //**************Add and save new Destination*****************
    @GetMapping("/AddDestination")
    public String addDestination(Model model){
        model.addAttribute("destination",new Destination());
        return "Add-destination-form";}
    @PostMapping("/saveDestination")
    public String saveDestination(@ModelAttribute("destination") Destination destination){
        destinationService.saveDestination(destination);
        return "redirect:/Home";

    }
    @GetMapping("/showDestinationsList")
    public String DestinationsList(Model model){
        model.addAttribute("destinations",destinationService.getDestinations());
        return "destinations-list";
    }

}
