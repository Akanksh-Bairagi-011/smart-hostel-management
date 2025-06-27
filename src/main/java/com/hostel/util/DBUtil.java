package com.hostel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "system";
private static final String PASS = "system";

    public static Connection getConnection() throws SQLException {
        try {
            // Load Oracle JDBC driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("DB Connected: " + conn);
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
