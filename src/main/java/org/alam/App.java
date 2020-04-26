package org.alam;

import com.alam.controller.EmployeeController;
import com.alam.vo.Address;
import com.alam.vo.Employee;

import javax.sound.midi.Soundbank;
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

        //Retrieve
        System.out.println(employeeController.getEmployee(0));

        Employee emp = new Employee();
        emp.setEmpId(4);
        emp.setFirstName("Wonder");
        emp.setLastName("Woman");

        //insert
        employeeController.saveEmployee(emp);

        //Retrieve
        System.out.println(employeeController.getEmployee(0));


        Employee emp1 = new Employee();
        emp1.setFirstName("Thanos");
        emp1.setLastName("Destroyer");

        //update
        employeeController.updateEmployee(4, emp1);

        //Retrieve
        System.out.println(employeeController.getEmployee(0));

        //Delete
        employeeController.deleteEmployee(4);

        //Retrieve
        System.out.println(employeeController.getEmployee(0));


    }
}
