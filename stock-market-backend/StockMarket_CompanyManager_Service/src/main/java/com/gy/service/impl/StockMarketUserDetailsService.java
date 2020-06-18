package com.gy.service.impl;

import com.gy.entity.StockMarketUserDetails;
import com.gy.entity.User;
import com.gy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StockMarketUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public StockMarketUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("No such user!");
        }

        if (user.getUsername() == null || user.getPassword() == null || user.getRole() == null) {
            log.error("The user [" + user + "] information is incomplete, please check!");
            return  null;
        }
        StockMarketUserDetails userDetails = new StockMarketUserDetails(user);

        return userDetails;
    }
}