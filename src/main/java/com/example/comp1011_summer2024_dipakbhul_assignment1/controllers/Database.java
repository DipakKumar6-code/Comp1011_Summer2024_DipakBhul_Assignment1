
package com.example.comp1011_summer2024_dipakbhul_assignment1.controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database class to handle the connection of PearsonAirport database on AWS RDS.
 */

public class Database {

    private static final String databaseUrl = "jdbc:mysql://database-2.czu8sy6gatbb.us-east-2.rds.amazonaws.com/PearsonAirport";
    private static final String dbUserName = "admin";
    private static final String dbPassword = "Dipakkumar34";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing the connection to retrieve data from the database
            connection = DriverManager.getConnection(databaseUrl, dbUserName, dbPassword);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection to the database failed!");
            System.out.println(e.getMessage());
        }
        return connection;
    }
}


