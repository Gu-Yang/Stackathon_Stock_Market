package com.gy.controller;

import com.gy.entity.User;
import com.gy.entity.request.UserNameRequest;
import com.gy.entity.request.UserRequest;
import com.gy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/findUser")
    public User findUser(@RequestBody UserNameRequest request) {
        Map<String, Object> map = new HashMap<>();
        User user = userService.findUserByUsername(request.getUsername());
        return user;
    }

    @PostMapping("/editUser")
    public void editUser(@RequestBody UserRequest request) {
        User user = userService.findUserByUsername(request.getUsername());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());

        userService.editUser(user);
    }

    @PostMapping("changePassword")
    public void changePassword(@RequestBody UserRequest request) {
        User user = userService.findUserByUsername(request.getUsername());
        user.setPassword(request.getPassword());

        userService.editUser(user);
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

    @GetMapping("/findAllUser")
    public List<User> findAllUser() {
        List<User> userList = userService.findAllUsers();
        return userList;
    }

    public void deleteAllUsers() {
        userService.removeAllUsers();
    }
}