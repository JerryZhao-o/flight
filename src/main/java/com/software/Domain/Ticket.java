package com.software.Domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ticket {

    String flightid;
    String seatlevel;
    String company;
    Integer count;

    public Ticket(String flightid, String seatlevel, String company, Integer count) {
        this.flightid = flightid;
        this.seatlevel = seatlevel;
        this.company = company;
        this.count = count;
    }
}
