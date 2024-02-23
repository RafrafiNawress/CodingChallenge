package com.subway.codingchallenge.security;


import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
@Slf4j
public class JWTUtils {

    public static String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, user);
    }

    private static String createToken(Map<String, Object> claims, User user) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .claim("role", user.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
                .compact();
    }


    public static String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public static Boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws((token.substring(SecurityConstants.TOKEN_PREFIX.length())))
                .getBody();
        return claimsResolver.apply(claims);
    }




}
