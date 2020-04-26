package com.alam.dao.impl;

import com.alam.dao.EmployeeDao;
import com.alam.vo.Employee;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/EMPLOYEES";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "admin1234$";

    Map<Integer, Employee> employeeMap = new HashMap<>();

    @Override
    public void saveEmployee(Employee employee) {
        String query = "INSERT INTO employee" +
                "  (empId, firstName, lastName) VALUES " +
                " (?, ?, ?);";
        insertEmployeeQuery(query, employee, "insert");
    }

    @Override
    public Employee getEmployee(Integer empId) {
        String query = "";
        if(empId == 0) {
            query = "SELECT * FROM employee";
        } else {
            query = "SELECT * FROM employee WHERE empId = " + empId;
        }
        return executeViewEmployeeQuery(query);
    }

    @Override
    public void updateEmployee(Integer empId, Employee employee) {
        //employeeMap.replace(empId, employee);
        String query = "UPDATE employee SET firstName=?, lastName=? WHERE empId=" + empId;
        insertEmployeeQuery(query, employee, "update");
    }

    @Override
    public void deleteEmployee(Integer empId) {
//        employeeMap.remove(empId);
//        return (employeeMap.get(empId) == null);
        String query = "DELETE FROM employee WHERE empId=" + empId;
        insertEmployeeQuery(query, null, "delete");

    }

    //Insert Employee Detail
    private void insertEmployeeQuery(String query, Employee emp, String isFrom){
        // Step 1: Establishing a Connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if(conn != null) {
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                switch (isFrom){
                    case "insert":
                        System.out.println("SQL Connection to database established! - INSERT");
                        preparedStatement.setInt(1, emp.getEmpId());
                        preparedStatement.setString(2, emp.getFirstName());
                        preparedStatement.setString(3,emp.getLastName());
                        break;
                    case "update":
                        System.out.println("SQL Connection to database established! - UPDATE");
                        preparedStatement.setString(1, emp.getFirstName());
                        preparedStatement.setString(2,emp.getLastName());
                        break;
                    case "delete":
                        System.out.println("SQL Connection to database established! - DELETE");
                        break;
                    default:
                        break;
                }

                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.executeUpdate();
            }
            else {
                    System.out.println("Connection Failed! Check output console");
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //To View the Employee Detail
    private Employee executeViewEmployeeQuery(String query) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if(conn != null) {
                System.out.println("SQL Connection to database established! - SELECT");
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                Employee emp = null;
                while (resultSet.next()){
                    emp = new Employee();
                    long employeeId = resultSet.getInt("empId");
                    String firstName = resultSet.getString("firstName");
                    String lastName =resultSet.getString("lastName");

                    emp.setEmpId((int) employeeId);
                    emp.setFirstName(firstName);
                    emp.setLastName(lastName);

                    System.out.println(employeeId+ " " +firstName+ " " +lastName);
                }
                return emp;
            } else {
                System.out.println("Connection Failed! Check output console");
            }
            conn.close();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
