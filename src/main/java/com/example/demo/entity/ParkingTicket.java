package com.example.demo.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;


@Entity
@Table(name = "parking-ticket")
public class ParkingTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    private LocalDateTime inTime;
    private LocalDateTime outTime;
    private VehicleType vehicleType;
    private Double finalBill;
    @NonNull
    private String licenseNumber;
    private Boolean isActive;

    private Integer spotId;

    public ParkingTicket(VehicleType vehicleType, @NonNull String licenseNumber) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.inTime = LocalDateTime.now();
        this.isActive = true;
    }

    public ParkingTicket getTicket(VehicleType vehicleType,String licenseNumber, Integer spotId){
        String vehicle = vehicleType.name().toLowerCase();
        return new ParkingTicket(vehicleType,licenseNumber);
    }

    @NonNull
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setFinalBill(Double finalBill, LocalDateTime outTime) {
        this.finalBill = finalBill;
        this.outTime = outTime;
        isActive = false;
    }

    public int getTicketId() {
        return ticketId;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Double getFinalBill() {
        return finalBill;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Integer getSpotId() {
        return spotId;
    }
}
