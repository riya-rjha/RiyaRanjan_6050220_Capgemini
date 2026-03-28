package cg.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Citizen {

    @Id
    private long adharNo;

    private String name;

    private String address;

    @OneToOne(mappedBy = "citizen")
    private IndianPassport ip;

    public Citizen() {
    }

    public Citizen(long adharNo, String name, String address) {
        this.adharNo = adharNo;
        this.name = name;
        this.address = address;
    }

    public long getAdharNo() {
        return adharNo;
    }

    public void setAdharNo(long adharNo) {
        this.adharNo = adharNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public IndianPassport getIp() {
        return ip;
    }

    public void setIp(IndianPassport ip) {
        this.ip = ip;
    }
}