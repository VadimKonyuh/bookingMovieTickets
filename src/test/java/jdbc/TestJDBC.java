package jdbc;

import com.konyuh.entity.User;
import com.konyuh.service.UserService;

import java.util.Iterator;
import java.util.List;

public class TestJDBC {
    public static void main(String[] args) {

        UserService userService = new UserService();

        List<User> users = userService.getUsers();

        Iterator iterator = users.iterator();
        while (iterator.hasNext()){
            User user1 = (User)iterator.next();
            System.out.println(user1);
        }
    }
}
