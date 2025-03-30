package com.presidency.petconnect.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;

@Entity

public class User {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private int userId;

    private String name;
    private String email;
    private String password;
    private String petPreferences;
    private long phone;
    private String address;
    private Timestamp createdAt;

    public User() {
    }

    public User(int userId, String name, String email, String password, String petPreferences, long phone, String address) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.petPreferences = petPreferences;
        this.phone = phone;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = Timestamp.from(Instant.now());
    }
}
