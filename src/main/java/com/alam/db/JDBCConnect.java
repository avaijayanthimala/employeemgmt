package com.alam.db;

import java.net.PasswordAuthentication;
import java.sql.*;


public class JDBCConnect {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/EMPLOYEES";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "admin1234$";

    public static void main(String[] args) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if(conn != null) {
                System.out.println("SQL Connection to database established!");

                PreparedStatement preparedStatement = conn.prepareStatement("select * from employee");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    long empId = resultSet.getInt("empId");
                    String firstName = resultSet.getString("firstName");
                    String lastName =resultSet.getString("lastName");
                    System.out.println(empId+ " " +firstName+ " " +lastName);
                }
            } else {
                System.out.println("Connection Failed! Check output console");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

    }//end main
}










