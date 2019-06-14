package com.software.Domain;

import java.util.List;

public class QueryOrder {
    Order order;
    List<Passenger> passengerList;

    public QueryOrder(Order order, List<Passenger> passengerList) {
        this.order = order;
        this.passengerList = passengerList;
    }
}
