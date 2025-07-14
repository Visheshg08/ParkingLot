package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.time.LocalDateTime;


public class ParkingTicket {
    private LocalDateTime inTime;
    private LocalDateTime outTime;
    private VehicleType vehicleType;
    private Double baseCharge;
    private Double finalBill;
    private Vehicle vehicleDetails;

}
