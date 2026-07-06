package com.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/stu_manage";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "daarsika@30_2005";

    /*static {
        try {
            Class.forName(DATABASE_DRIVER); // Load Driver only once
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load database driver", e);
        }
    }*/

    // Get a new DB connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }
}