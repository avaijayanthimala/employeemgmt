package com.alam.vo;
import java.io.Serializable;
import java.util.List;

/* 1. Object info - UI display , DB persist we used

2. In Java, if you want to take an data outside the application you should be implement it as serializable

3.Interface has no methods in it. It is like markered interface.
Markered interface means it doesn't have any methods define in it.

4. It tells an information to JVM ie., this obj is build to transfer b/w applications

5. If want to take it as JSON to show it in UI and want to store it in DB then you impl as serializable in network
 it is convert the object into bytestream and send it */

public class Employee implements Serializable {

    // If you are declaring it is private you cannot access this outside of the class

    private Integer empId;
    private String firstName;
    private String lastName;
    private List<Address> addressList;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressList=" + addressList +
                '}';
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    /** how to access the private object outside means using getter and setter you can access it.
        Based on attributes it will create getter and setter.
        In this eg: getEmpId() get g is small case E is Capital - camelcase.
        If you put the E is in small case Same as like hibernate, spring will not work.
        Based on the camelCase only spring will access this attribute with the help of reflection
    */

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
