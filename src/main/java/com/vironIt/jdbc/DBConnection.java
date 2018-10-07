package com.vironIt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static final String DB_URL = "jdbc:postgresql:booking_cinema_tickets";
    static final String USER ="postgres";
    static final String PASS ="postgres";

    public static void init(){
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        }catch (SQLException e){
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        finally {
            if(connection != null){
                connection.close();
                System.out.println("You successfully connected to database now");
            }else {
                System.out.println("Failed to make connection to database");
            }
        }
        return  connection;
    }
}


//public static void main(String[] args) {
//
//        System.out.println("Testing connection to PostgreSQL JDBC");
//
//        try{
//        Class.forName("org.postgresql.Driver");
//        }catch (ClassNotFoundException e){
//        System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
//        e.printStackTrace();
//        return;
//        }
//
//        System.out.println("PostgreSQL JDBC Driver successfully connected");
//        Connection connection = null;
//
//        try {
//        connection = DriverManager.getConnection(DB_URL, USER, PASS);
//
//        }catch (SQLException e) {
//        System.out.println("Connection Failed");
//        e.printStackTrace();
//        return;
//        }finally {
//        try {
//        connection.close();
//        }catch (SQLException e){
//
//        }
//
//        }
//        if (connection != null) {
//        System.out.println("You successfully connected to database now");
//        } else {
//        System.out.println("Failed to make connection to database");
//        }
//        }