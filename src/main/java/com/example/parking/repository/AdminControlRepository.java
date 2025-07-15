package com.example.parking.repository;

import com.example.parking.entity.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminControlRepository extends CrudRepository<Admin,Integer> {
}
