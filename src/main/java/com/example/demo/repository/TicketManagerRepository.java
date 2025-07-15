package com.example.demo.repository;

import com.example.demo.entity.ParkingTicket;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TicketManagerRepository extends CrudRepository<ParkingTicket, Integer> {
    ParkingTicket getActiveTicket(String licenseNumber);
    ArrayList<ParkingTicket> getAllTickets(String licenseNumber);
}
