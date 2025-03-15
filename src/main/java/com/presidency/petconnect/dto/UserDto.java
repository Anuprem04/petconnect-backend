
package com.presidency.petconnect.dto;

import java.sql.Timestamp;

public class UserDto {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String petPreferences;
    private long phone;
    private String city;
    private Timestamp createdAt;

    public UserDto() {}

    public UserDto(int userId, String name, String email, String password, String petPreferences, long phone, String city, Timestamp createdAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.petPreferences = petPreferences;
        this.phone = phone;
        this.city = city;
        this.createdAt = createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPetPreferences() {
        return petPreferences;
    }

    public void setPetPreferences(String petPreferences) {
        this.petPreferences = petPreferences;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
