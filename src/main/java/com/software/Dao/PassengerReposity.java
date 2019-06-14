package com.software.Dao;

import com.software.Domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerReposity extends JpaRepository<Passenger, Integer> {
    List<Passenger> findAllByOrderid(Integer orderid);
}
