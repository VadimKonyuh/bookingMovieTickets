package com.vironIt.db.dao.impl;

import com.vironIt.connectionpool.HikariCPDataSource;
import com.vironIt.db.dao.CinemaDAO;
import com.vironIt.entity.Cinema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaDAOImpl implements CinemaDAO {

    public static final String SQL_FIND_CINEMA_BY_ID = "SELECT * FROM cinema WHERE id = ?";
    public static final String SQL_FIND_CINEMA_BY_NAME = "SELECT * FROM cinema WHERE name = ?";
    public static final String SQL_FIND_CINEMA_BY_NAME_ADDRESS = "SELECT * FROM cinema WHERE (name = ? AND address = ?)";
    public static final String SQL_CINEMA_CREATE = "INSERT INTO cinema (name, address) VALUES (?, ?)";
    public static final String SQL_CINEMA_UPDATE= "UPDATE  \"cinema\" SET name = ?, address = ? WHERE  id = ?";
    public static final String SQL_CINEMA_REMOVE = "DELETE FROM cinema WHERE id = ?";
    public static final String SQL_FIND_ALL = "SELECT * FROM cinema";

    @Override
    public Cinema find(Integer id) {
        Cinema cinema = new Cinema();

        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CINEMA_BY_ID);){

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                cinema.setId(resultSet.getInt(1));
                cinema.setName(resultSet.getString(2));
                cinema.setAddress(resultSet.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return cinema;
    }


    public Cinema findCinemaByName(String name){
        Cinema cinema = new Cinema();

        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CINEMA_BY_NAME);){

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                cinema.setId(resultSet.getInt(1));
                cinema.setName(resultSet.getString(2));
                cinema.setAddress(resultSet.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cinema;
    }


    public Cinema findCinemaByNameAddress(String name, String address){
        Cinema cinema = new Cinema();
        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CINEMA_BY_NAME_ADDRESS);){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                cinema.setId(resultSet.getInt(1));
                cinema.setName(resultSet.getString(2));
                cinema.setAddress(resultSet.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cinema;
    }


    @Override
    public void create(Cinema cinema) {
        try(Connection connection = HikariCPDataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_CINEMA_CREATE)) {

            preparedStatement.setString(1, cinema.getName());
            preparedStatement.setString(2, cinema.getAddress());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cinema cinema) {

        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CINEMA_UPDATE)){

            preparedStatement.setString(1, cinema.getName());
            preparedStatement.setString(2, cinema.getAddress());
            preparedStatement.setInt(3, cinema.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Cinema cinema) {
        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CINEMA_REMOVE)){

            preparedStatement.setInt(1, cinema.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void deleteCinemaById(Integer id){
        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CINEMA_REMOVE)){
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



    @Override
    public List<Cinema> findAll() {
        List cinemas = null;
        try(Connection connection =  HikariCPDataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL)){
            cinemas = this.initCinemass(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cinemas;
    }

//    public Cinema getById(Integer userId){
//        Cinema cinemaDb = new Cinema();
//        CinemaDAOImpl cinemaDAO = new CinemaDAOImpl();
//        List<Cinema> cinemas =  cinemaDAO.findAll();
//        for (Cinema cinema : cinemas){
//            if(cinema.getId().equals(userId)){
//                cinemaDb = cinema;
//            }
//        }
//        return cinemaDb;
//    }

    private ArrayList<Cinema> initCinemass(ResultSet resultSet) throws SQLException{
        ArrayList cinemas = new ArrayList();

        while (resultSet.next()){
            Cinema cinema = new Cinema();
            cinema.setId(resultSet.getInt(1));
            cinema.setName(resultSet.getString(2));
            cinema.setAddress(resultSet.getString(3));
            cinemas.add(cinema);
        }
        return cinemas;
    }
}
