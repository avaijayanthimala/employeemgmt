package com.alam.controller;

import com.alam.service.EmployeeService;
import com.alam.service.impl.EmployeeServiceImpl;
import com.alam.vo.Employee;

public class EmployeeController {
/*First we need to call the service Interface
we cannot create the object for the Interface it will create the annonymus class.
So to do that we need to call the Interface service class ku mattium than obj create panna mudiyum
*/
    EmployeeService employeeService = new EmployeeServiceImpl();

    //CRUD operation

    //Save
    public void saveEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
    }

    //Get
    public Employee getEmployee(Integer empId) {
        return employeeService.getEmployee(empId);
    }

    //update
    public void updateEmployee(Integer empId, Employee employee) {
        employeeService.updateEmployee(empId, employee);
    }
    //remove
    public Boolean deleteEmployee(Integer empId) {
        return employeeService.deleteEmployee(empId);
    }
}
