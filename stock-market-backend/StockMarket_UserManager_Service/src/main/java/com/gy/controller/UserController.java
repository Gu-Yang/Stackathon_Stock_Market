package com.gy.controller;

import com.gy.entity.User;
import com.gy.entity.request.UserNameRequest;
import com.gy.entity.request.UserRequest;
import com.gy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findUser")
    public User findUser(@RequestBody UserNameRequest request) {
        Map<String, Object> map = new HashMap<>();
        User user = userService.findUserByUsername(request.getUsername());
        return user;
    }

    @GetMapping("/test")
    public String test() {
        return "Test";
    }

    @PostMapping("/signup")
    public void addUser(@RequestBody UserRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());
        user.setRole("normal");

        userService.addUser(user);
    }

    public void deleteAllUsers() {
        userService.removeAllUsers();
    }
}