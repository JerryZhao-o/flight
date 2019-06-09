package com.software.Domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="order_")
public class Order {
    @Id
    @Column(name = "orderid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderid;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "status")
    private String status; //未付款 付款未发货 发货

    @Column(name = "ordertime")
    private Date ordertime;

    @ManyToOne
    private User userid;

    @OneToOne
    private Flight flightid;

    @OneToOne
    private Payment paymentid;

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Flight getFlightid() {
        return flightid;
    }

    public void setFlightid(Flight flightid) {
        this.flightid = flightid;
    }

    public Payment getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Payment paymentid) {
        this.paymentid = paymentid;
    }
}
