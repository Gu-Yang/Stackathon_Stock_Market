package com.gy.service;

import com.gy.entity.User;
import com.gy.entity.request.UserNameRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    public User getUserByUsername(String username) {

        if (username == null || username.isBlank()) {
            return null;
        }

        UserNameRequest request = new UserNameRequest();
        request.setUsername(username);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity("http://localhost:8081/findUser", request, User.class);

        return userResponseEntity.getBody();
    }
}