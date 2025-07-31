package com.smartcare.dto;

public class AuthenticationResponse {
    private String jwt;

    // Constructors, Getters and Setters
    public AuthenticationResponse() {}

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}