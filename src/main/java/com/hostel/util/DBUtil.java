package com.hostel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "system";
    private static final String PASS = "system"; // Change to your actual password

    public static Connection getConnection() throws SQLException {
        try {
            // Load Oracle JDBC driver class (important)
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        }

        // Establish the connection
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
