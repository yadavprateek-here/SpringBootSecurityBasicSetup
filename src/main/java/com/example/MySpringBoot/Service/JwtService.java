package com.example.MySpringBoot.Service;

import com.example.MySpringBoot.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }
    public String generateAccessToken(User user) {
       return  Jwts.builder()
                .subject(user.getId().toString())
                .claim("username",user.getUsername())
                .claim("name",user.getName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60))
                .signWith(getSecretKey())
                .compact();
    }

    public String generateRefreshToken(User user) {
        return  Jwts.builder()
                .subject(user.getId().toString())
                .claim("username",user.getUsername())
                .claim("name",user.getName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*60*5))
                .signWith(getSecretKey())
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return Long.parseLong(claims.getSubject());
    }
}
