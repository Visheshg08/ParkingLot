package com.example.demo.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "spring")
public class AppConfig {

    private Ticket ticket;

    public static class Ticket {
        private double hourlyCharges;

        // Getters and Setters
        public double getHourlyCharges() { return hourlyCharges; }
        public void setHourlyCharges(double hourlyCharges) { this.hourlyCharges = hourlyCharges; }
    }

    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


}
