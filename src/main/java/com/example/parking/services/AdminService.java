package com.example.parking.services;

import com.example.parking.entity.ParkingLot;
import com.example.parking.entity.ParkingSpot;
import com.example.parking.repository.AdminControlRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class AdminService {

    private AdminControlRepository adminControlRepository;
    private ParkingSpotService parkingSpotService;
    private ParkingLotService parkingLotService;

    public AdminService(AdminControlRepository adminControlRepository, ParkingSpotService parkingSpotService, ParkingLotService parkingLotService) {
        this.adminControlRepository = adminControlRepository;
        this.parkingSpotService = parkingSpotService;
        this.parkingLotService = parkingLotService;
    }


    public void addParkingSpots(List<ParkingSpot> parkingSpots){
        ParkingLot parkingLot = parkingLotService.getParkingLot();
        parkingSpots.forEach( it -> it.setParkingLotId(parkingLot.getParkingLotId()));
        parkingSpotService.createParkingSpots(parkingSpots);
    }

    public void deleteParkingSpot(Integer spotId){
        parkingSpotService.deleteParkingSpot(spotId);
    }
}
