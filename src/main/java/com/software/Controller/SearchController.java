package com.software.Controller;

import com.software.Dao.FlightRepository;
import com.software.Domain.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class SearchController {
    private FlightRepository flightRepository;

    @GetMapping(value = "/search/{source}/{destination}")
    public List<Flight> search(@PathVariable(value = "source")String source,
                               @PathVariable(value = "destination") String destination){

        return flightRepository.findALLBySourceAndDestination(source, destination);
    }
}
