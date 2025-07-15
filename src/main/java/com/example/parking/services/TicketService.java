package com.example.parking.services;

import com.example.parking.Exceptions.NoDataFoundException;
import com.example.parking.configuration.VehicleConfig;
import com.example.parking.entity.ParkingSpot;
import com.example.parking.entity.ParkingTicket;
import com.example.parking.entity.VehicleType;
import com.example.parking.repository.TicketManagerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class TicketService {

    TicketManagerRepository ticketManagerRepository;
    ParkingSpotService parkingService;
    ParkingTicket parkingTicket;
    VehicleConfig vehicleConfig;

    public ParkingTicket generateEntryTicket(VehicleType vehicleType, String licenseNumber){
        ParkingSpot parkingSpot = parkingService.getNearestAvailableSpot(vehicleType);
        ParkingTicket ticket = parkingTicket.getTicket(vehicleType,licenseNumber,parkingSpot.getSpotId());
        parkingService.fillSpot(parkingSpot.getSpotId());
        ticketManagerRepository.save(ticket);
        return ticket;
    }

    public ParkingTicket getActiveTicket(String licenseNumber){
        return ticketManagerRepository. findByLicenseNumberAndActive(licenseNumber,true)
                .orElseThrow(() -> new NoDataFoundException("No Active Ticket found for licenseNumber: " + licenseNumber));
    }

    public List<ParkingTicket> getVehicleHistory(String licenseNumber){
        return ticketManagerRepository.findByLicenseNumber(licenseNumber)
                .orElseThrow( () -> new NoDataFoundException("No ticket history found for license Number: " + licenseNumber));

    }

    public ParkingTicket getExitTicket(String licenseNumber){
        ParkingTicket activeTicket = getActiveTicket(licenseNumber);
        LocalDateTime currTime = LocalDateTime.now();
        long totalHours = ChronoUnit.HOURS.between( activeTicket.getInTime(), currTime);
        double totalBill;
        if(totalHours == 0) totalHours+=1;
        totalBill = totalHours *  vehicleConfig.getVehicleCharge(activeTicket.getVehicleType());
        activeTicket.setFinalBill(totalBill, currTime);
        ticketManagerRepository.save(activeTicket);
        return activeTicket;
    }



}
