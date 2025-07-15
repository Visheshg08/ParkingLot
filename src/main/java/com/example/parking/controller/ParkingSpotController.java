package com.example.parking.controller;

import com.example.parking.entity.ParkingSpot;
import com.example.parking.services.ParkingSpotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @GetMapping("/find-vehicle")
    public ParkingSpot findVehicle(@RequestParam("licenseNumber") String licenseNumber){
        return parkingSpotService.getParkingSpotOfVehicle(licenseNumber);
    }
}
