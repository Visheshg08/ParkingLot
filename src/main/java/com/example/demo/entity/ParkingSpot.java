package com.example.demo.entity;

import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;

@Entity
@Table(name = "parking-spot")
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spotId;
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
