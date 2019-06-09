package com.software.Dao;

import com.software.Domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepositury extends JpaRepository<Flight,Integer> {
    List<Flight> findALLBySourceAndDestination(String source, String destination);
}
