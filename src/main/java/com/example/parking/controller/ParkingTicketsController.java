package com.example.parking.controller;



import com.example.parking.entity.ParkingTicket;
import com.example.parking.entity.VehicleType;
import com.example.parking.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingTicketsController {

    private final TicketService ticketService;

    public ParkingTicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @GetMapping("/generate-ticket")
    public ParkingTicket generateEntryTicket(@RequestParam("vehicleType") VehicleType vehicleType,@RequestParam("licenseNumber") String licenseNumber){
        return ticketService.generateEntryTicket(vehicleType,licenseNumber);

    }

    @GetMapping("/generate-bill")
    public ParkingTicket generateBill(@RequestParam("licenseNumber") String licenseNumber){
        return ticketService.getExitTicket(licenseNumber);
    }

    @GetMapping("/vehicle-history")
    public List<ParkingTicket> getVehicleHistory(@RequestParam("licenseNumber") String licenseNumber){
        return ticketService.getVehicleHistory(licenseNumber);
    }

}
