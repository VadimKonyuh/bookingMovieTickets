package com.vironIt.db.dao.impl;

import com.vironIt.connectionpool.HikariCPDataSource;
import com.vironIt.db.dao.BaseDAO;
import com.vironIt.db.dao.CinemaDAO;
import com.vironIt.entity.Cinema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaDAOImpl implements CinemaDAO {

    public static final String SQL_FIND_CINEMA = "SELECT * FROM cinema WHERE id = ?";
    public static final String SQL_CREATE_CINEMA = "INSERT INTO cinema (name, address, is_open) VALUES (?, ?, ?)";
    public static final String SQL_CINEMA_UPDATE= "SELECT * FROM cinema WHERE (name = ?, address = ?, is_open = ?)";
    public static final String SQL_CINEMA_REMOVE = "DELETE FROM cinema WHERE id = ?";
    public static final String SQL_FIND_ALL = "SELECT * FROM cinema";

    @Override
    public Cinema find(Integer id) {
        Cinema cinema = new Cinema();

        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CINEMA);){

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                cinema.setId(resultSet.getInt(1));
                cinema.setName(resultSet.getString(2));
                cinema.setAddress(resultSet.getString(3));
                cinema.setIsOpen(resultSet.getBoolean(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return cinema;
    }



    @Override
    public void create(Cinema cinema) {
        try(Connection connection = HikariCPDataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_CINEMA)) {

            preparedStatement.setString(1, cinema.getName());
            preparedStatement.setString(2, cinema.getAddress());
            if (cinema.getIsOpen() != null) {
                preparedStatement.setBoolean(3, cinema.getIsOpen());
            }else {
                preparedStatement.setBoolean(3, false);
            }
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
            preparedStatement.setBoolean(3, cinema.getIsOpen());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Cinema cinema) {
        //        String sql = "DELETE FROM \"user\" WHERE id = ?";
        try(Connection connection = HikariCPDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CINEMA_REMOVE)){
            preparedStatement.setInt(1, cinema.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }



    @Override
    public List<Cinema> findAll() {
        List cinemas = null;
//        String sql = "SELECT * FROM cinema";
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
            cinema.setIsOpen(resultSet.getBoolean(4));
            cinemas.add(cinema);
        }
        return cinemas;
    }
}
