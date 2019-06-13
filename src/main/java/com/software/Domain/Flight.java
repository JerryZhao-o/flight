package com.software.Domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="flight")
public class Flight {
    @Id
    @Column(name = "flightid",nullable = false)
    private String flightid;

    @Column(name="source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departuretime")
    private String departuretime;

    @Column
    private String landingtime;

    @Column
    private java.sql.Date departuredate;

    @ManyToOne
    @JoinColumn(name = "companyid")
    private Company company;

    public String getFlightid() {
        return flightid;
    }

    public void setFlightid(String flightid) {
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

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departurtime) {
        this.departuretime = departurtime;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getLandingtime() {
        return landingtime;
    }

    public void setLandingtime(String landingtime) {
        this.landingtime = landingtime;
    }

    public java.sql.Date getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(java.sql.Date departuredate) {
        this.departuredate = departuredate;
    }
}
