package com.example.parking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parking-spots")
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spotId;
    private Integer parkingLotId;
    private VehicleSize spotSize;
    private Boolean isEmpty;
    private Integer floor;

    public Integer getSpotId() {
        return spotId;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public Integer getFloor() {
        return floor;
    }
}
