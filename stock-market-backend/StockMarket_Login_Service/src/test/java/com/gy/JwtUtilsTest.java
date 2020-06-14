package com.gy;

import com.gy.entity.StockMarketUserDetails;
import com.gy.entity.User;
import com.gy.utils.Constants;
import com.gy.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

@SpringBootTest
public class JwtUtilsTest {

    @Test
    public void testCreateJwt() {
        User user = new User();
        user.setUsername("gyangcd");
        user.setPassword("123456");
        user.setName("GuYang");
        user.setRole(Constants.ROLE_ADMIN);

        UserDetails userDetails = new StockMarketUserDetails(user);

        String token = JwtUtils.generateJsonWebToken((StockMarketUserDetails) userDetails);
        System.out.println("Token: " + token);
    }

    @Test
    public void testCheckJwt() {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiYWRtaW4iLCJleHAiOjE1OTI0ODgxNjYsImlhdCI6MTU5MTg4MzM2NiwidXNlcm5hbWUiOiJneWFuZ2NkIn0.LyzK4vGhE2oZ9ekEPwb94nSB-VnjfnNNjnZZbP3Vt-s";

        Claims claims = JwtUtils.getClaims(token);
        Date expirationDate = claims.getExpiration();
        System.out.println("Expiration Data: " + expirationDate);

        System.out.println("Username: " + claims.get(JwtUtils.USERNAME_CLAIM));
        System.out.println("Role: " + claims.get(JwtUtils.ROLE_CLAIM));
    }

        @Test
        public void testGetMethods() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiYWRtaW4iLCJleHAiOjE1OTI0ODgxNjYsImlhdCI6MTU5MTg4MzM2NiwidXNlcm5hbWUiOiJneWFuZ2NkIn0.LyzK4vGhE2oZ9ekEPwb94nSB-VnjfnNNjnZZbP3Vt-s";

        System.out.println("isExpired: " + JwtUtils.isExpired(token));

        System.out.println("Username: " + JwtUtils.getUsername(token));
        System.out.println("Role: " +  JwtUtils.getRole(token));
    }
}