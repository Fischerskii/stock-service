package com.example.stockservice.secutity.jwt;

public interface JwtProvider {

    String generateJwt(String username);

    boolean validateJwt(String token);

    String getUsernameFromJwt(String token);
}
