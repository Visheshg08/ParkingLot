package com.example.demo.repository;

import com.example.demo.entity.ParkingSpot;
import com.example.demo.entity.VehicleType;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ParkingSpotRepository extends CrudRepository<ParkingSpotRepository,Integer> {

    public ArrayList<ParkingSpot> getEmptySpots(VehicleType vehicleType);

    public ParkingSpot getNearestEmptySpot(VehicleType vehicleType);

    public Boolean fillSpot(Integer spotId);

    public ParkingSpot getVehicleSpot(String spotId);

}
