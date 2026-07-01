package com.example.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String jdbcurl="jdbc:mysql://localhost:3306/mydatabase";
    static final String username="root";
    static final String password="daarsika@30_2005";

    public static Connection getConnectionToServer() throws SQLException{
        return DriverManager.getConnection(jdbcurl,username,password);
    }
    public static void getConnection() throws SQLException {
        String dbname = InputUtil.getDbname();
        if(dbname==null){
            throw new SQLException("Database name is null");

        }

    }
    public static void close (AutoCloseable resource){
        if(resource != null){
            try{
                resource.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

