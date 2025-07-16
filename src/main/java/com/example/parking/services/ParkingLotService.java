package com.example.parking.services;

import com.example.parking.entity.ParkingLot;

public class ParkingLotService {


    public ParkingLot getParkingLot(){
        return ParkingLot.getInstance();
    }

}
