package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.HashMap;


public class ParkingLot {
    private Integer totalLevels;
    private ArrayList<ParkingFloor> levelData;
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

    public void setLevelData(ArrayList<ParkingFloor> levelData) {
        this.levelData = levelData;
    }

    public void setPrices(HashMap<VehicleType, Double> prices) {
        this.prices = prices;
    }

    public Integer getTotalLevels() {
        return totalLevels;
    }

    public ArrayList<ParkingFloor> getLevelData() {
        return levelData;
    }

    public HashMap<VehicleType, Double> getPrices() {
        return prices;
    }
}
