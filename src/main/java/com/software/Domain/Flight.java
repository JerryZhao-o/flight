package com.software.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="flight")
public class Flight {
    @Id
    @Column(name = "flightid",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightid;

    @Column(name="source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departurtime")
    private Date departurtime;

    @ManyToOne
    @JoinColumn(name = "companyid")
    private Aircompany aircompany;

    public Integer getFlightid() {
        return flightid;
    }

    public void setFlightid(Integer flightid) {
        this.flightid = flightid;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDeparturtime() {
        return departurtime;
    }

    public void setDeparturtime(Date departurtime) {
        this.departurtime = departurtime;
    }

    public Aircompany getAircompany() {
        return aircompany;
    }

    public void setAircompany(Aircompany aircompany) {
        this.aircompany = aircompany;
    }
}
