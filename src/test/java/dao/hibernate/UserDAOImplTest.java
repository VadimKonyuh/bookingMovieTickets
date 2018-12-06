package dao.hibernate;

import com.vironIt.db.dao.impl.UserDAOImplHibernate;
import com.vironIt.entity.User;
import org.junit.Before;
import org.junit.Test;

public class UserDAOImplTest {

    UserDAOImplHibernate userDAOImplHibernate;
    User user;

    @Before
    public void initialize(){
        userDAOImplHibernate = new UserDAOImplHibernate();
        user = new User();
    }

    @Test
    public void findUser(){
        userDAOImplHibernate.findById((long) 50);
    }

    @Test
    public void addUser(){
        user.setLogin("TestHibernateDAOImpl");
        user.setPassword("TestHibernateDAOImpl");
        userDAOImplHibernate.create(user);
    }

    @Test
    public void updateUser(){
        User user1 = userDAOImplHibernate.findById((long) 68);
        user1.setLogin("newTestHibernateLogin");
        userDAOImplHibernate.update(user1);
    }

    @Test
    public void deleteUser(){
//        User user1 = userDAOImplHibernate.findById((long) 67);
//        userDAOImplHibernate.delete(user1);
    }

    @Test
    public void findAll(){
        userDAOImplHibernate.findAll();
    }

    @Test
    public void getUserByLoginPassword(){
        user = userDAOImplHibernate.getUserByLoginPassword("vadim", "vadim");
        System.out.println(user);
    }
}
