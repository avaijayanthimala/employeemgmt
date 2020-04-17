package org.alam;

import com.alam.controller.EmployeeController;
import com.alam.vo.Address;
import com.alam.vo.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        EmployeeController employeeController = new EmployeeController();

        Employee emp = new Employee();
        emp.setEmpId(2112);
        emp.setFirstName("Vaijayanthimala");
        emp.setLastName("Anandhan");

        Address address = new Address();
        address.setDoorNo(26);
        address.setStreetName("VGP street");
        address.setCity("Chennai");
        address.setState("TamilNadu");
        address.setZipCode("600042");

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);

        emp.setAddressList(addressList);
        //Create
        employeeController.saveEmployee(emp);
        //Retrieve
        System.out.println(employeeController.getEmployee(2112));

        emp.setFirstName("Vijay Anand");
        emp.setLastName("Balasubramanian");

        //update
        employeeController.updateEmployee(2112, emp);

        //Retrieve
        System.out.println(employeeController.getEmployee(2112));

        //Delete
        System.out.println(employeeController.deleteEmployee(2112));

        //Retrieve
        System.out.println(employeeController.getEmployee(2112));
    }
}
