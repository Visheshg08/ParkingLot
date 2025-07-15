package com.example.parking.services;


import com.example.parking.Exceptions.ParkingSpotNotFoundException;
import com.example.parking.entity.ParkingSpot;
import com.example.parking.entity.VehicleType;
import com.example.parking.repository.ParkingSpotRepository;
import org.springframework.stereotype.Component;

@Component
public class ParkingSpotService {


    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingSpot getNearestAvailableSpot(VehicleType vehicleType){
        return parkingSpotRepository.getNearestEmptySpot(vehicleType)
                .orElseThrow(() -> new ParkingSpotNotFoundException("No parking Spot Available for: " + vehicleType));
    }

    public void fillSpot(ParkingSpot parkingSpot){
        parkingSpot.setEmpty(false);
        parkingSpotRepository.save(parkingSpot);

    }

    public void relieveSpot(ParkingSpot parkingSpot){
        parkingSpot.setEmpty(true);
        parkingSpotRepository.save(parkingSpot);
    }

    public ParkingSpot getSpotById(Integer spotId){
        return parkingSpotRepository.findById(spotId)
                .orElseThrow(() -> new ParkingSpotNotFoundException("No such parking spot exists with spotId: " + spotId));
    }

//    public Boolean isSpotAvailable(VehicleType vehicleType){
//        return parkingSpotRepository.getEmptySpots(vehicleType).isPresent();
//    }

    public ParkingSpot getParkingSpotOfVehicle(String licenseNumber){
        return parkingSpotRepository.getVehicleSpot(licenseNumber)
                .orElseThrow(() -> new ParkingSpotNotFoundException("No spot for license: " + licenseNumber));
    }


}
