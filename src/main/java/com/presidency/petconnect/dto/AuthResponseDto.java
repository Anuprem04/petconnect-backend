package com.presidency.petconnect.dto;

public class AuthResponseDto {
    private String token;
    private String role;

    public AuthResponseDto() {}

    public AuthResponseDto(String token, String role) {
        this.token = token;
        this.role = role;
    }

    // Getters and setters

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
