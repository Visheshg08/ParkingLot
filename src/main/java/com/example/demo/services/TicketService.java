package com.example.demo.services;

import com.example.demo.configuration.AppConfig;
import com.example.demo.entity.ParkingSpot;
import com.example.demo.entity.ParkingTicket;
import com.example.demo.entity.VehicleType;
import com.example.demo.repository.TicketManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

@Component
public class TicketService {

    @Autowired
    TicketManagerRepository ticketManagerRepository;
    @Autowired
    SpotService parkingService;
    @Autowired
    ParkingTicket parkingTicket;
    @Autowired
    AppConfig config;

    public ParkingTicket generateEntryTicket(VehicleType vehicleType, String licenseNumber){
        ParkingSpot parkingSpot = parkingService.getNearestAvailableSpot(vehicleType);
        ParkingTicket ticket = parkingTicket.getTicket(vehicleType,licenseNumber,parkingSpot.getSpotId());
        parkingService.fillSpot(parkingSpot.getSpotId());
        ticketManagerRepository.save(ticket);
        return ticket;
    }

    public ParkingTicket getActiveTicket(String licenseNumber){
        ParkingTicket activeTicket = ticketManagerRepository.getActiveTicket(licenseNumber);
        return  activeTicket;
    }

    public ArrayList<ParkingTicket> getVehicleHistory(String licenseNumber){
        ArrayList<ParkingTicket> allTickets = ticketManagerRepository.getAllTickets(licenseNumber);
        return allTickets;
    }

    public ParkingTicket getExitTicket(String licenseNumber){
        ParkingTicket activeTicket = ticketManagerRepository.getActiveTicket(licenseNumber);
        LocalDateTime currTime = LocalDateTime.now();
        long totalHours = ChronoUnit.HOURS.between( activeTicket.getInTime(), currTime);
        double totalBill = 0D;
        if(totalHours == 0) totalHours+=1;
        totalBill = totalHours * config.getTicket().getHourlyCharges();
        activeTicket.setFinalBill(totalBill, currTime);
        ticketManagerRepository.save(activeTicket);
        return activeTicket;
    }



}
