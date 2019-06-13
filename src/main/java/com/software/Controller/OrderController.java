package com.software.Controller;

import com.software.Dao.FlightRepository;
import com.software.Dao.SeatRepository;
import com.software.Domain.Flight;
import com.software.Domain.Seat;
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

    @RequestMapping(value = "/search")
    public List<Flight> search(
            @RequestParam("source") String source,
            @RequestParam("destination") String destination,
            @RequestParam("departuredate") String departuredate){
        System.out.println("收到信息请求");
        System.out.println(source+destination+departuredate);

        // findSeatByFlightid
        Map<Flight, Integer[]> ticketnumber = new HashMap<>();
        List<Flight> flightList = flightRepository.findBySourceAndDestinationAndDeparturedate(source, destination, departuredate);
        for(Flight i : flightList)
        {
//            List<Seat> seatList = new ArrayList<Seat>();
//            seatList = seatRepository.findSeatByFlightid(i.getFlightid());

            System.out.println(i.getFlightid());
            Integer[] seatnumber = new Integer[3];
            List<Seat> seatList1 = seatRepository.findSeatByFlightidAndSeatlevel(i.getFlightid(), "头等舱");
            List<Seat> seatList2 = seatRepository.findSeatByFlightidAndSeatlevel(i.getFlightid(), "普通舱");
            List<Seat> seatList3 = seatRepository.findSeatByFlightidAndSeatlevel(i.getFlightid(), "经济舱");
            seatnumber[0] = seatList1.size();
            seatnumber[1] = seatList2.size();
            seatnumber[2] = seatList3.size();
            ticketnumber.put(i, seatnumber);
        }
        return flightList;
    }

    @RequestMapping(value = "/order")
    public void order(@RequestParam("fightid") String flightid,
                      @RequestParam("seatlevel") String seatlevel,
                      @RequestParam("passengernumber") Integer passengernumber,
                      @RequestParam("passengerinfo") List<String> passengerinfo){
        System.out.println(passengerinfo.toString());



    }

    @RequestMapping(value = "queryorder")
    public void queryordre(@RequestParam("userid") Integer userid)
    {

    }


}
