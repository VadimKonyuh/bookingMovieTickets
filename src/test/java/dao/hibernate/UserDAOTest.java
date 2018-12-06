package dao.hibernate;

import com.vironIt.utils.JPAUtility;
import com.vironIt.entity.User;
import com.vironIt.entity.enums.Role;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;

public class UserDAOTest {

    User user;
    @Before
    public void  initialize(){
        user = new User();
        user.setLogin("HibernateTest");
        user.setPassword("HibernateTest");
        user.setFirstName("HibernateTest");
        user.setLastName("HibernateTest");
        user.setEmail("HibernateTest");
        user.setRole(Role.USER);
    }

    @Test
    public void create(){
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.persist(user);
    }

    @Test
    public void read(){
        EntityManager entityManager = JPAUtility.getEntityManager();
        User user = entityManager.find(User.class, (long) 70);
        System.out.println(user);
    }

    @Test
    public void update(){
        EntityManager entityManager = JPAUtility.getEntityManager();
        user.setLogin("TestHiberante");
        entityManager.merge(user);
    }

    @Test
    public void delete(){
        EntityManager entityManager = JPAUtility.getEntityManager();
        User user = entityManager.find(User.class,(long) 57);
        entityManager.remove(user);
    }
}
