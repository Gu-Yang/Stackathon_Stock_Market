package com.gy.service.impl;

import com.gy.entity.User;
import com.gy.repository.UserRepository;
import com.gy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void editUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void removeAllUsers() {
        userRepository.deleteAll();
    }


}