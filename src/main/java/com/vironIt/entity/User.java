package com.vironIt.entity;


import com.vironIt.entity.enums.Role;
import lombok.Data;

@Data
public class User {

    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
