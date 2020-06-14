package com.gy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String username;
    private String password;

    private String name;
    private String email;
    private String mobile;
    private String role;

//    public User(String password, String name, String email, String mobile) {
//        this.password = password;
//        this.name = name;
//        this.email = email;
//    }
}
