package com.example.parking.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "spring")
public class AppConfig {

    private VehicleTypePrices vehicleTypePrices;

    public static class VehicleTypePrices {
        private double hourlyCharges;

        // Getters and Setters
        public double getHourlyCharges() { return hourlyCharges; }
        public void setHourlyCharges(double hourlyCharges) { this.hourlyCharges = hourlyCharges; }
    }




}
