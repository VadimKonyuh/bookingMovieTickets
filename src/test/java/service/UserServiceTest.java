package service;

import com.vironIt.entity.User;
import com.vironIt.service.UserService;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class UserServiceTest {

     @Test
     public void getAllUserTest(){
        UserService userService = new UserService();
        List<User> users = userService.getUsers();
        Iterator iterator = users.iterator();
        while (iterator.hasNext()){
            User user1 = (User)iterator.next();
            System.out.println(user1);
        }
    }
}
