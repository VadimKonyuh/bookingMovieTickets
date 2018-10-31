package dao;

import com.vironIt.entity.User;
import com.vironIt.entity.enums.Role;

public class Psv {
    public static void main(String[] args) {
        Role role = Role.ADMIN;
        User user = new User();
        System.out.println(role);
        System.out.println(user + "" + user);
    }
}
