package com.alam.vo;

import java.io.Serializable;

public class Address implements Serializable {

    private Integer empId;
    private Integer doorNo;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;

    @Override
    public String toString() {
        return "Address{" +
                "empId=" + empId +
                ", doorNo=" + doorNo +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(Integer doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
