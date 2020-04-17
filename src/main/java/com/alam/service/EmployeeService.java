package com.alam.service;

//In interface everything you are declared is public, there is no use for creating it in private

import com.alam.vo.Employee;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    Employee getEmployee(Integer empId);

    void updateEmployee(Integer empId, Employee employee);

    Boolean deleteEmployee(Integer empId);
}
