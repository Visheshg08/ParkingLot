package com.example.parking.configuration;

import com.example.parking.entity.VehicleType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "vehicle.type")
public class VehicleConfig {
    private Map<VehicleType, Double> types;

    public Map<VehicleType, Double> getTypes() {
        return types;
    }

    public Double getVehicleCharge(VehicleType vehicleType){
        return types.get(vehicleType);
    }

}
