package com.software.Domain;

import javax.persistence.*;

@Entity
@Table(name="company")
public class Company {
    @Id
    @Column(name = "companyid",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyid;

    @Column
    private String companyname;

    @Column(name = "companyusername")
    private String companyusername;

    @Column(name = "companypassword")
    private String companypassword;

    @Column
    private String companymail;

    @Column
    private String companyphone;

    @Column
    private  String address;

    public String getCompanyusername() {
        return companyusername;
    }

    public void setCompanyusername(String companyusername) {
        this.companyusername = companyusername;
    }

    public String getCompanypassword() {
        return companypassword;
    }

    public void setCompanypassword(String companypassword) {
        this.companypassword = companypassword;
    }


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
