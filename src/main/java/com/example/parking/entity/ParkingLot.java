package com.example.parking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parkingLotId;
    private Integer totalLevels;
    private String name;
    public static ParkingLot instance;

    public static ParkingLot getInstance() {
        if(instance == null){
            instance = new ParkingLot(121,3);
        }
        return instance;
    }

    public ParkingLot(Integer parkingLotId, Integer totalLevels) {
        this.parkingLotId = parkingLotId;
        this.totalLevels = totalLevels;
    }

    private ParkingLot() {
    }

    public void setTotalLevels(Integer totalLevels) {
        this.totalLevels = totalLevels;
    }

    public Integer getTotalLevels() {
        return totalLevels;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }
}
