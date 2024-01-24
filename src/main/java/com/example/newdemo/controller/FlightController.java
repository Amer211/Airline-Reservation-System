package com.example.newdemo.controller;

import com.example.newdemo.entity.Flight;
import com.example.newdemo.entity.Plane;
import com.example.newdemo.service.DestinationService;
import com.example.newdemo.service.FlightService;
import com.example.newdemo.service.PlaneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

import static com.example.newdemo.entity.Flight.generateFlightNumber;

@Controller
public class FlightController {
    private final FlightService flightService;
    private final DestinationService destinationService;
    private final PlaneService planeService;

    public FlightController(FlightService flightService, DestinationService destinationService, PlaneService planeService) {
        this.flightService = flightService;
        this.destinationService = destinationService;
        this.planeService = planeService;
    }


    //**********Add and save new flights************************
    @GetMapping("/AddFlight")
    public String addFlight(Model model){
        model.addAttribute("flight",new Flight());
        model.addAttribute("destinations", destinationService.getDestinations());
        model.addAttribute("planes", planeService.getPlanes());
        return "Add-flight-form";
    }
    @PostMapping("/saveFlight")
    public String saveFlight(@ModelAttribute("flight") Flight flight,
                             @RequestParam("planeId") int planeId){
        flight.setFlightNumber(generateFlightNumber());
        Optional<Plane> plane = planeService.findPlaneById(planeId);
        if(plane.isPresent()){
            Plane plane1 = plane.get();
            flight.setPlane(plane1);
        }



        flightService.saveFlight(flight);
        return "redirect:/Home";
    }

    //************************show all flights*************************
    @GetMapping("/showFlightsList")
    public String flightsList(Model model){
        model.addAttribute("flights",flightService.findFlights());
        return "flights-list";
    }

    //find flight by id
    @GetMapping("/searchFlightById")
    public String searchFlightById(){
        return "find-flight-by-id";
    }



    //************************find flight by id*********************
    @GetMapping("/findFlight")
    public String findFlightById(@RequestParam("id") String flightId, Model model) {
        Optional<Flight> flight = flightService.findById(flightId);
        if (flight.isPresent()) {
            model.addAttribute("flight", flight.get());
        } else {
            model.addAttribute("errorMessage", "Flight not found with the provided ID.");
        }

        return "flightByIdResult";
    }

    //************** search flight to book**********************
    @GetMapping("/search")
    public String searchFlight(Model model){
        model.addAttribute("destinations",destinationService.getDestinations());

        return "search-flight-form";
    }
    @GetMapping("/showFlights")
    public String searchFlightResult(@RequestParam("from") String departure,
                                     @RequestParam("to") String arrival,
                                     Model model){

        List<Flight> flights = flightService.findByDepartureArrival(departure,arrival);
        model.addAttribute("flights",flights);
        return "results-list";


    }
}
