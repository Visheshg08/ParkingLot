package com.example.demo.services;


import com.example.demo.entity.ParkingSpot;
import com.example.demo.entity.VehicleType;
import com.example.demo.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SpotService {

    @Autowired
    ParkingSpotRepository parkingSpotRepository;



    public ParkingSpot getNearestAvailableSpot(VehicleType vehicleType){
        ParkingSpot parkingSpot = parkingSpotRepository.getNearestEmptySpot(vehicleType);
        return  parkingSpot;
    }

    public void fillSpot(Integer spotId){
        parkingSpotRepository.fillSpot(spotId);

    }
    public Boolean isSpotAvailable(VehicleType vehicleType){
        ArrayList<ParkingSpot> parkingSpots = parkingSpotRepository.getEmptySpots(vehicleType);
        return !parkingSpots.isEmpty();
    }

    public ParkingSpot getParkingSpotOfVehicle(String licenseNumber){
        ParkingSpot parkingSpot = parkingSpotRepository.getVehicleSpot(licenseNumber);
        return parkingSpot;
    }


}
