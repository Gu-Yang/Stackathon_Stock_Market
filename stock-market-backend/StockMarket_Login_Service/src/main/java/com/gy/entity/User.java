package com.gy.entity;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private String mobile;
    private String role;
}