package com.software.Controller;

import com.software.Dao.FlightRepositury;
import com.software.Domain.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class SearchController {
    private FlightRepositury flightRepositury;

    @GetMapping(value = "/search/{source}/{destination}")
    public List<Flight> search(@PathVariable(value = "source")String source,
                               @PathVariable(value = "destination") String destination){

        return flightRepositury.findALLBySourceAndDestination(source, destination);
    }
}
