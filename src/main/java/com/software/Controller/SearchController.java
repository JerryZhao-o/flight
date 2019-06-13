package com.software.Controller;

import com.software.Dao.FlightRepository;
import com.software.Dao.SeatRepository;
import com.software.Domain.Flight;
import com.software.Domain.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class SearchController {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private SeatRepository seatRepository;

    @RequestMapping(value = "/companysearch")
    public List<Flight> search(
            @RequestParam("startcity") String source,
            @RequestParam("endcity") String destination,
            @RequestParam("date") String departuredate,
            @RequestParam("companyid") Integer companyid) throws ParseException {


        System.out.println(source+destination+departuredate+companyid);
        String timePattern = "yyyy-MM-dd";
            // 将Date转换成指定形式的时间字符串
            SimpleDateFormat sdf = new SimpleDateFormat(timePattern);
//            String formatedDate = sdf.format(departuredate);
//            System.out.println(formatedDate);

            // 将时间字符串转换成java.util.Date对象
            Date date = sdf.parse(departuredate);
//            System.out.println(date.toString());

//        departuredate = Date.p
        for(Flight i : flightRepository.findALLBySourceAndDestinationAndDeparturedateAndCompanyid(source, destination, departuredate, companyid))
        {
            System.out.println(i.toString());
        }

        return flightRepository.findALLBySourceAndDestinationAndDeparturedateAndCompanyid(source, destination, departuredate, companyid);


    }

    @RequestMapping(value = "/circle")
    public int[][] circle(@RequestParam("companyid") Integer companyid) {
        int[][] data = new int[2][3];
        List<Seat> seatList1 = seatRepository.findSeat1ByCompanyid(companyid);
        List<Seat> seatList2 = seatRepository.findSeat2ByCompanyid(companyid);
        List<Seat> seatList3 = seatRepository.findSeat3ByCompanyid(companyid);

        data[0][0] = seatList1.size();
        data[0][1] = seatList2.size();
        data[0][2] = seatList3.size();

        data[1][0] = 0;
        data[1][1] = 0;
        data[1][2] = 0;
        for (Seat seat : seatList1) {
            data[1][0] += Integer.parseInt(seat.getPrice());
        }

        for (Seat seat : seatList2) {
            data[1][1] += Integer.parseInt(seat.getPrice());
        }

        for (Seat seat : seatList3) {
            data[1][2] += Integer.parseInt(seat.getPrice());
        }

        return data;    // data[0] 为张数
    }                   // data[1] 为销售额


    @RequestMapping(value = "/line")
    public int[][] line(@RequestParam("companyid") Integer companyid) {
        int[][] data = new int[12][2];
        return data;    // data[x][0] 为x月张数
    }                   // data[x][1] 为x月销售额

    @RequestMapping(value = "deletflight")
    public boolean delet(@RequestParam("companyid") Integer companyid,
                         @RequestParam("flightid") String flightid) {


        return true;
    }

    @RequestMapping(value = "addflight")
    public boolean addflight(@RequestParam("companyid") Integer companyid,
                       @RequestParam("flightid") String flightid,
                       @RequestParam("source") String source,
                       @RequestParam("destination") String destination,
                       @RequestParam("departuretime") Date departuretime,
                       @RequestParam("daparturedata") Date daparturedata,
                       @RequestParam("landingtime") java.sql.Date departuredate,
                       @RequestParam("seat1price") String price1,
                       @RequestParam("seat1number") String seat1number,
                       @RequestParam("seat2price") String price2,
                       @RequestParam("seat1number") String seat2number,
                       @RequestParam("seat3price") String price3,
                       @RequestParam("seat1number") String seat3number
                       )
    {
        return true;

    }
}


/*@Id
    private Integer seatid;

    @Column
    private String seatlevel; //头等舱 普通舱 经济舱

    @Column(name = "price")
    private String price;

    @Column(name = "isempty")
    private String isempty; //空  不空

    @ManyToOne
    @JoinColumn(name = "flightid")
    private Flight flight;*/
