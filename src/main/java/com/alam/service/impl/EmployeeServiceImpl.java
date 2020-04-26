package com.alam.service.impl;

import com.alam.dao.EmployeeDao;
import com.alam.dao.impl.EmployeeDaoImpl;
import com.alam.service.EmployeeService;
import com.alam.vo.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Override
    public Employee getEmployee(Integer empId) {
        return employeeDao.getEmployee(empId);
    }

    @Override
    public void updateEmployee(Integer empId, Employee employee) {
        employeeDao.updateEmployee(empId, employee);
    }

    @Override
    public void deleteEmployee(Integer empId) { employeeDao.deleteEmployee(empId);
    }
}
