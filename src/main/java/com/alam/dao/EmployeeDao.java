package com.alam.dao;

import com.alam.vo.Employee;

public interface EmployeeDao {

    void saveEmployee(Employee employee);

    Employee getEmployee(Integer empId);

    void updateEmployee(Integer empId, Employee employee);

    Boolean deleteEmployee(Integer empId);
}
