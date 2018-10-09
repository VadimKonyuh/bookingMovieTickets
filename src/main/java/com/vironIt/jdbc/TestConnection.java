package com.vironIt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.vironIt.jdbc.HikariCPDataSource.*;

public class TestConnection {
    public static void main(String[] args) {
        try(Connection connection =  getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, login FROM \"user\"");){
                while (resultSet.next()){
                    int i = resultSet.getInt("id");
                    String string = resultSet.getString(2);
                    System.out.println(resultSet.getRow() + "." + i + " " + string);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    TestConnection(){

    }
}
