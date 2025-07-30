package com.smartcare.dto;

// A record is a concise way to create immutable data carrier classes
public record AuthenticationRequest(String username, String password) {}