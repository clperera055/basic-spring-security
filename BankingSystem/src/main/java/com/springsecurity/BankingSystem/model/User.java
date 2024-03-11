package com.springsecurity.BankingSystem.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;
    private String email;
    private String password;
    private String role;

    public User(String email, String password, String role) {

        this.email = email;
        this.password = password;
        this.role = role;
    }

}
