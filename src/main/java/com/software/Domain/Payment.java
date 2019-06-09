package com.software.Domain;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "paymentid",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentid;

    @Column(name = "paytime")
    private Date paytime;

    @Column(name = "paymethod") //支付宝，微信，银行卡
    private String paymethod;

    public Integer getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getPaymetho() {
        return paymethod;
    }

    public void setPaymetho(String paymetho) {
        this.paymethod = paymetho;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

}
