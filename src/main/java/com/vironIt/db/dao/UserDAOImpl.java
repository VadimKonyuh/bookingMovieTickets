package com.vironIt.db.dao;

import com.vironIt.entity.User;
import com.vironIt.jdbc.HikariCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    public UserDAOImpl() {
    }

    public void addUser(User user) {
        PreparedStatement preparedStatement = null;

        try(Connection connection =  HikariCPDataSource.getConnection()){
            preparedStatement = connection.prepareStatement("INSERT INTO \"user\" (id, login, password, first_name, last_name, e_mail, role) VALUES (?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setLong  (1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirst_name());
            preparedStatement.setString(5, user.getLast_name());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getRole());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("");
        }finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            }catch (SQLException e){
                System.out.println("SQL exception occurred during add client");
                e.printStackTrace();
            }
        }


    }


    public List<User> getUsers() {
        List users = null;

        try(Connection connection =  HikariCPDataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM \"user\"")){
            users = this.initClients(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Возникла ошибка");
        }

        return users;
    }

    private List<User> initClients(ResultSet resultSet) throws SQLException{
        ArrayList users = new ArrayList();

        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setLogin(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setFirst_name(resultSet.getString(4));
            user.setLast_name(resultSet.getString(5));
            user.setEmail(resultSet.getString(6));
            user.setRole(resultSet.getString(7));
            users.add(user);
        }

        return users;
    }
}
