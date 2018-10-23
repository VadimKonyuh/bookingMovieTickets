package com.vironIt.db.dao;

import com.sun.istack.internal.NotNull;
import com.vironIt.entity.User;
import com.vironIt.jdbc.HikariCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    public UserDAOImpl() {
    }

    @Override
    public void addUser(User user) {
        PreparedStatement preparedStatement = null;

        try(Connection connection =  HikariCPDataSource.getConnection()){
            preparedStatement = connection.prepareStatement("INSERT INTO \"user\" (login, password, first_name, last_name, e_mail, role) VALUES (?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirst_name());
            preparedStatement.setString(4, user.getLast_name());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getRole());

            preparedStatement.executeUpdate();
            System.out.println("User add");

        } catch (SQLException e) {
            e.printStackTrace();

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

    @Override
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


    @Override
    public User getById(Long id) {
        String sql = "SELECT * FROM \"user\" WHERE ID = ?";
        User user = new User();

        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement  preparedStatement = connection.prepareStatement("SELECT * FROM \"user\" WHERE ID = ?")){

            preparedStatement.setLong(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            user.setId(resultSet.getLong(1));
            user.setLogin(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setFirst_name(resultSet.getString(4));
            user.setLast_name(resultSet.getString(5));
            user.setEmail(resultSet.getString(6));
            user.setRole(resultSet.getString(7));

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void update(User user) {

        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE \"user\" SET id = ?, login = ?, password = ?, first_name = ?, last_name = ?, e_mail = ?, role = ?")){
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirst_name());
            preparedStatement.setString(5, user.getLast_name());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getRole());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void remove(Long id) {

        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM \"user\" WHERE id = ?")){
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
                e.printStackTrace();
        }
    }

    public User getUserByLoginPassword(String name, String password){
        String sql = "SELECT * FROM \"user\" WHERE login = ? AND password = ?";
        User user = new User();

        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement  preparedStatement = connection.prepareStatement("SELECT * FROM \"user\" WHERE login = ? AND password = ?")){

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setFirst_name(resultSet.getString(4));
                user.setLast_name(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setRole(resultSet.getString(7));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public User getById(long userId){
        User userFromDb = new User();
        UserDAOImpl userDAO = new UserDAOImpl();
        List<User> users;
        users = userDAO.getUsers();

        for (User user: users){
            if(user.getId().equals(userId)){
                userFromDb = user;
            }
        }

        return userFromDb;
    }


    private List<User> initClients(ResultSet resultSet) throws SQLException{
        ArrayList users = new ArrayList();

        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getLong(1));
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
