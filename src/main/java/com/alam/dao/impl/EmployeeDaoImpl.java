package com.alam.dao.impl;

import com.alam.dao.EmployeeDao;
import com.alam.vo.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {

    Map<Integer, Employee> employeeMap = new HashMap<>();

    @Override
    public void saveEmployee(Employee employee) {
        // You can write the DB logic here
        employeeMap.put(employee.getEmpId(), employee);
    }

    @Override
    public Employee getEmployee(Integer empId) {
        return employeeMap.get(empId);
    }

    @Override
    public void updateEmployee(Integer empId, Employee employee) {
        employeeMap.replace(empId, employee);
    }

    @Override
    public Boolean deleteEmployee(Integer empId) {
        employeeMap.remove(empId);
        return (employeeMap.get(empId) == null);

    }

}
