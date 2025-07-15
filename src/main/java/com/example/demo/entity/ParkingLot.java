package com.example.demo.entity;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class ParkingLot {
    private Integer totalLevels;
    private ArrayList<ParkingSpot> parkingSpots;
    private HashMap<VehicleType,Double> prices;
    public static ParkingLot instance;

    public static ParkingLot getInstance() {
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;
    }

    private ParkingLot() {
    }

    public void setTotalLevels(Integer totalLevels) {
        this.totalLevels = totalLevels;
    }

    public void setPrices(HashMap<VehicleType, Double> prices) {
        this.prices = prices;
    }

    public Integer getTotalLevels() {
        return totalLevels;
    }

    public HashMap<VehicleType, Double> getPrices() {
        return prices;
    }
}
