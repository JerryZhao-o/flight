package com.software.Controller;

import com.software.Dao.*;
import com.software.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class OrderController {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PassengerReposity passengerReposity;


    @RequestMapping(value = "/search")
    public List<Ticket> search(
            @RequestParam("source") String source,
            @RequestParam("destination") String destination,
            @RequestParam("departuredate") String departuredate){
        System.out.println("收到信息请求");
        System.out.println(source+destination+departuredate);

        // findSeatByFlightid
        List<Ticket> ticketList = new ArrayList<>();
        List<Flight> flightList = flightRepository.findBySourceAndDestinationAndDeparturedate(source, destination, departuredate);
        for(Flight i : flightList)
        {
//            List<Seat> seatList = new ArrayList<Seat>();
//            seatList = seatRepository.findSeatByFlightid(i.getFlightid());

            System.out.println(i.getFlightid());
            List<Seat> seatList1 = seatRepository.findSeatByFlightidAndSeatlevel(i.getFlightid(), "头等舱");
            List<Seat> seatList2 = seatRepository.findSeatByFlightidAndSeatlevel(i.getFlightid(), "普通舱");
            List<Seat> seatList3 = seatRepository.findSeatByFlightidAndSeatlevel(i.getFlightid(), "经济舱");
            Company company = i.getCompany();
            String companyname = companyRepository.findByCompanyid(i.getCompany().getCompanyid()).getCompanyname();
            Ticket ticket1 = new Ticket(i.getFlightid(), companyname, "头等舱", seatList1.size());
            Ticket ticket2 = new Ticket(i.getFlightid(), companyname, "头等舱", seatList2.size());
            Ticket ticket3 = new Ticket(i.getFlightid(), companyname, "头等舱", seatList3.size());
            ticketList.add(ticket1);
            ticketList.add(ticket2);
            ticketList.add(ticket3);
        }
        return ticketList;
    }

    @RequestMapping(value = "/order")
    public void order(@RequestParam("fightid") String flightid,
                      @RequestParam("seatlevel") String seatlevel,
                      @RequestParam("passengernumber") Integer passengernumber,
                      @RequestParam("passengerinfo") List<String> passengerinfo){
        System.out.println(passengerinfo.toString());



    }

    @RequestMapping(value = "queryorder")
    public List<QueryOrder> queryordre(@RequestParam("userid") Integer userid)
    {
        List<QueryOrder> queryOrderList= new ArrayList<>();
        List<Order> orderList = orderRepository.findAllByUserid(userid);
        for(Order i : orderList)
        {
            List<Passenger> passengerList = passengerReposity.findAllByOrderid(i.getOrderid());
            QueryOrder queryOrder = new QueryOrder(i, passengerList);
            queryOrderList.add(queryOrder);
        }
        return queryOrderList;
    }


}
