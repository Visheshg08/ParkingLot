package com.example.parking.repository;

import com.example.parking.entity.ParkingSpot;
import com.example.parking.entity.VehicleType;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ParkingSpotRepository extends CrudRepository<ParkingSpot,Integer> {

    public Optional<ArrayList<ParkingSpot>> getEmptySpots(VehicleType vehicleType);

    public Optional<ParkingSpot> getNearestEmptySpot(VehicleType vehicleType);



    public Optional<ParkingSpot> getVehicleSpot(String spotId);

}
