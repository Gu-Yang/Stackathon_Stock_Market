package com.gy.service;

import com.gy.entity.User;

public interface UserService {
    User findUserByUsername(String username);
    void addUser(User user);
    void editUser(User user);
    void removeUser(User user);
    void removeAllUsers();
}
