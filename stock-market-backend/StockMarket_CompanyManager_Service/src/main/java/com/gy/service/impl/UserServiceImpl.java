package com.gy.service.impl;

import com.gy.entity.User;
import com.gy.entity.request.UserNameRequest;
import com.gy.service.RemoteUserService;
import com.gy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RemoteUserService remoteUserService;

    @Override
    public User getUserByUsername(String username) {

        if (username == null || username.isBlank()) {
            return null;
        }

        UserNameRequest request = new UserNameRequest();
        request.setUsername(username);

        return remoteUserService.findUser(request);

    }
}