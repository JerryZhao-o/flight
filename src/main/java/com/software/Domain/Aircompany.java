package com.software.Domain;

import javax.persistence.*;

@Entity
@Table(name="aircompany")
public class Aircompany {
    @Id
    @Column(name = "companyid",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyid;

    @Column(name="companyname")
    private String companyname;


    @Column(name = "companymail")
    private String companymail;

    @Column(name = "companyphone")
    private String companyphone;

    @Column(name = "address")
    private  String address;

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanymail() {
        return companymail;
    }

    public void setCompanymail(String companymail) {
        this.companymail = companymail;
    }

    public String getCompanyphone() {
        return companyphone;
    }

    public void setCompanyphone(String companyphone) {
        this.companyphone = companyphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
