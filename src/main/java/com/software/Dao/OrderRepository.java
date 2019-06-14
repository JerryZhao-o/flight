package com.software.Dao;

import com.software.Domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
//    Order Save(Order order);
    List<Order> findAllByUserid(Integer userid);

}
