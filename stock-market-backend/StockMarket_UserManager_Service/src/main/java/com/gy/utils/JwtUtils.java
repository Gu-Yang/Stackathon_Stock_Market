package com.gy.utils;

import com.gy.entity.StockMarketUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String SUBJECT = "stock_market";
    public static final String APPSECRET_KEY = "stock_market_secret";

    public static final String ROLE_CLAIM = "role";
    public static final String USERNAME_CLAIM = "username";

    public static final long EXPIRATION = 1000 * 24 * 60 * 60 * 7;

    public static String generateJsonWebToken(StockMarketUserDetails userDetails) {

        if (userDetails.getUsername() == null || userDetails.getRole() == null) {
            return null;
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put(USERNAME_CLAIM, userDetails.getUsername());
        claims.put(ROLE_CLAIM, userDetails.getRole());

        String token = Jwts
                .builder()
                .setSubject(SUBJECT)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY)
                .compact();

        return token;
    }

    public static Claims getClaims(String token) {

        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims;
    }

    public static String getUsername(String token) {
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get(USERNAME_CLAIM).toString();
    }

    public static String getRole(String token) {
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get(ROLE_CLAIM).toString();
    }

    public static boolean isExpired(String token) {
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }




}