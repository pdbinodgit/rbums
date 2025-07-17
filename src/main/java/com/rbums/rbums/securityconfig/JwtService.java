package com.rbums.rbums.securityconfig;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtService {

    private long EXPIRATION_TIME=1000*60*60*6;

    private static  final String SECRET_KEY="rbums_secret_key_secret_key_for_rbums";

    private final Key key= Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String extractUsernameFormToken(String token){
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }
    public boolean isTokenValid(String token,String username){
        return extractUsernameFormToken(token).equals(username);
    }
}
