package jdbc;


import com.vironIt.db.dao.UserDAOImpl;
import com.vironIt.entity.User;
import org.junit.Test;

public class TestDAO {

    @Test
    public void testAddUser(){

    }

    @Test
    public void testGetUserByID(){
        User user;
        UserDAOImpl userDAO = new UserDAOImpl();
        user = userDAO.getById(997);
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
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.remove((long) 998);
    }

    @Test
    public void testFind(){
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.find("vadim","13");
        System.out.println(user);
    }

    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.remove(new Long(998));
    }
}
