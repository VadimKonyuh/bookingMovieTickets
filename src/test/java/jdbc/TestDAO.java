package jdbc;

import com.vironIt.db.dao.UserDAOImpl;
import com.vironIt.entity.User;
import com.vironIt.jdbc.HikariCPDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDAO {

    @Test
    public void testAddUser(){

    }

    @Test
    public void testGetUserByID(){
        User user;
        UserDAOImpl userDAO = new UserDAOImpl();
        user = userDAO.getById(1000);
        System.out.println(user);

    }

    @Test
    public void testUpdateUser(){
    User user = new User((long) 11233,"vadim","vadim","vadim","vadim","vadim","vadim");
    UserDAOImpl userDAO = new UserDAOImpl();
        System.out.println(userDAO.getById( user.getId()));
    userDAO.update(user);
        System.out.println(userDAO.getById( user.getId()));
    }

    @Test
    public void testRemove(){
        User user = new User((long) 1000,"vadim","vadim","vadim","vadim","vadim","vadim");
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.remove((long) 1000);

    }

    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.remove((long) 1000);
//        User user = new User((long) 1000,"vadim","vadim","vadim","vadim","vadim","vadim");
//        UserDAOImpl userDAO = new UserDAOImpl();
//        userDAO.remove((long) 1000);
//        try(Connection connection =  HikariCPDataSource.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT id, login FROM \"user\"");){
//            while (resultSet.next()){
//                int i = resultSet.getInt("id");
//                String string = resultSet.getString(2);
//                System.out.println(resultSet.getRow() + ". " + i + " " + string);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        };
    }

}
