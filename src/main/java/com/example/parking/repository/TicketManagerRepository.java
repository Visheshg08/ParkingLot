package com.example.parking.repository;

import com.example.parking.entity.ParkingTicket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TicketManagerRepository extends CrudRepository<ParkingTicket, Integer> {
    Optional<ParkingTicket> findByLicenseNumberAndActive(String licenseNumber, Boolean isActive);
    Optional<List<ParkingTicket>>  findByLicenseNumber(String licenseNumber);
}
