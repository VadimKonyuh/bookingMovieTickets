package dao;


import com.vironIt.db.dao.impl.UserDAOImpl;
import com.vironIt.entity.User;
import com.vironIt.entity.enums.Role;
import org.junit.Before;
import org.junit.Test;

public class TestDAOUser {

    @Before
    public void createUser(){
        User user = new User();
        user.setFirstName("Vadim");
        user.setLastName("Vadim");
        user.setRole(Role.ADMIN);
        System.out.println(user);
    }

    @Test
    public void testAddUser(){
        User user = new User();
        UserDAOImpl userDAO = new UserDAOImpl();
        user.setLogin("user");
        user.setPassword("user");
        user.setFirstName("user");
        user.setLastName("user");
        user.setEmail("user");
        user.setRole(Role.USER);
        userDAO.addUser(user);
    }

    @Test
    public void testGetUserByID(){
        User user;
        UserDAOImpl userDAO = new UserDAOImpl();
        user = userDAO.getById((long) 63);
        System.out.println(user);
    }

    @Test
    public void testUpdateUser(){
    UserDAOImpl userDAO = new UserDAOImpl();
    User user = userDAO.getUserByLoginPassword("User","user");

        System.out.println(userDAO.getById( user.getId()));
        user.setLogin("User");
        userDAO.update(user);
        System.out.println(userDAO.getById( user.getId()));
    }

    @Test
    public void testRemove(){
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.remove(new Long(998));
    }

    @Test
    public void testFind(){
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUserByLoginPassword("vadim","13");
        System.out.println(user);
        System.out.println(user.getLogin() != null);
    }

    @Test
    public void getUserByLoginPassword(){
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.getUserByLoginPassword("vadim","13");
        System.out.println(user);
        System.out.println(user.getLogin() != null);
    }
}
