package com.software.Dao;

import com.software.Domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer> {
    List<Flight> findALLBySourceAndDestination(String source, String destination);
}
