package com.gy.controller;

import com.gy.entity.StockMarketUserDetails;
import com.gy.entity.User;
import com.gy.entity.request.AuthenticationRequest;
import com.gy.entity.request.UserNameRequest;
import com.gy.entity.response.AuthenticationResponse;
import com.gy.service.StockMarketUserDetailsService;
import com.gy.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private StockMarketUserDetailsService stockMarketUserDetailsService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Security!";
    }

    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception{

        String username = request.getUsername();
        String password = request.getPassword();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password");
        }

        final UserDetails userDetails = stockMarketUserDetailsService.loadUserByUsername(username);
        final String token =JwtUtils.generateJsonWebToken((StockMarketUserDetails) userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

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