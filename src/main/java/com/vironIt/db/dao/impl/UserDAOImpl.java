package com.vironIt.db.dao.impl;

import com.vironIt.db.dao.UserDAO;
import com.vironIt.entity.User;
import com.vironIt.connectionpool.HikariCPDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final String SQL_ADD_USER = "INSERT INTO \"user\" (login, password, first_name, last_name, e_mail, role) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_GET_USERS = "SELECT * FROM \"user\"";
    private static final String SQL_GET_USER_BY_ID = "SELECT * FROM user WHERE user.id = ?";
    private static final String SQL_YSER_UPDATE = "UPDATE  \"user\" SET login = ?, password = ?, first_name = ?, last_name = ?, e_mail = ?, role = ? WHERE  id = ?" ;
    private static final String SQL_USER_REMOVE = "DELETE FROM \"user\" WHERE id = ?";
    private static final String SQL_GET_USER_BY_LOGIN_PASSWORD = "SELECT * FROM \"user\" WHERE login = ? AND password = ?";

    public UserDAOImpl() {
    }

    @Override
    public void addUser(User user) {
        PreparedStatement preparedStatement = null;

        try(Connection connection =  HikariCPDataSource.getConnection()){
//            String sql = "INSERT INTO \"user\" (login, password, first_name, last_name, e_mail, role) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(SQL_ADD_USER);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getRole().toString());
            preparedStatement.executeUpdate();

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
//        String sql = "SELECT * FROM \"user\"";

        try(Connection connection =  HikariCPDataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_GET_USERS)){
            users = this.initClients(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }

        return users;
    }


    @Override
    public User getById(Long id) {
        String sql = "SELECT * FROM \"user\" WHERE id = ?";
        User user = new User();

        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement  preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setLong(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setFirstName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setRole(resultSet.getString(7));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void update(User user) {
//        String sql = "UPDATE \"user\" SET id = ?, login = ?, password = ?, first_name = ?, last_name = ?, e_mail = ?, role = ?";
        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_YSER_UPDATE)){
//            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getRole().toString());
            preparedStatement.setLong(7, user.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void remove(Long id) {
//        String sql = "DELETE FROM \"user\" WHERE id = ?";
        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_USER_REMOVE)){
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
                e.printStackTrace();
        }
    }


    public User getUserByLoginPassword(String name, String password){
//        String sql = "SELECT * FROM \"user\" WHERE login = ? AND password = ?";
        User user = new User();

        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement  preparedStatement = connection.prepareStatement(SQL_GET_USER_BY_LOGIN_PASSWORD)){ ;
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setFirstName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setEmail(resultSet.getString(6));
                user.setRole(resultSet.getString(7));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }


//    public User getById(long userId){
//        User userFromDb = new User();
//        UserDAOImpl userDAO = new UserDAOImpl();
//        List<User> users;
//        users = userDAO.getUsers();
//
//        for (User user: users){
//            if(user.getId().equals(userId)){
//                userFromDb = user;
//            }
//        }
//        return userFromDb;
//    }


    private List<User> initClients(ResultSet resultSet) throws SQLException{
        ArrayList users = new ArrayList();

        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getLong(1));
            user.setLogin(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setFirstName(resultSet.getString(4));
            user.setLastName(resultSet.getString(5));
            user.setEmail(resultSet.getString(6));
            user.setRole(resultSet.getString(7));
            users.add(user);
        }
        return users;
    }
}
