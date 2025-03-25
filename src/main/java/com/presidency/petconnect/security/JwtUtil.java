package com.presidency.petconnect.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

    // Generate a secure key with at least 256 bits for HS256
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long jwtExpirationInMs = 3600000; // 1 hour

    @Value("${jwt.secret}")
    private String base64Secret;

    public String generateToken(String email, String role, Integer id) {
        byte[] keyBytes = Base64.getDecoder().decode(base64Secret);
        Key key = Keys.hmacShaKeyFor(keyBytes);
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .claim("id", id)
                .signWith(key)
                .compact();
    }
}
