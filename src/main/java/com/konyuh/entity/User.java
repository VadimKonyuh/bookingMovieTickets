package com.konyuh.entity;

import com.konyuh.entity.enums.Role;
import lombok.Data;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "user", schema = "public")
public class User{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "user_id_seq")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "e_mail")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
