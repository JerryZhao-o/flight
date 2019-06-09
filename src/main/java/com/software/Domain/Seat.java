package com.software.Domain;

import javax.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    private Integer seatid;

    @Column
    private String seatlevel; //头等舱 普通舱 经济舱

    @Column(name = "price")
    private String price;

    @Column(name = "isempty")
    private String isempty; //空  不空

    @ManyToOne
    @JoinColumn(name = "flightid")
    private Flight flight;


    public String getIsempty() {
        return isempty;
    }

    public void setIsempty(String isempty) {
        this.isempty = isempty;
    }

    public Integer getSeatid() {
        return seatid;
    }

    public void setSeatid(Integer seatid) {
        this.seatid = seatid;
    }

    public String getSeatlevel() {
        return seatlevel;
    }

    public void setSeatlevel(String seatlevel) {
        this.seatlevel = seatlevel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

}
