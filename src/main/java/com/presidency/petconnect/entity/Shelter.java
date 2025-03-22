package com.presidency.petconnect.entity;

import jakarta.persistence.*;

@Entity
public class Shelter {
    @Id
    @SequenceGenerator(name = "shelter_seq", sequenceName = "shelter_sequence", initialValue = 2000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shelter_seq")
    private int shelterId;

    private String name;
    private String email;
    private String password;
    private String city;
    private String phone;

    public Shelter() {
    }

    public Shelter(int shelterId, String name, String email, String password, String city, String phone) {
        this.shelterId = shelterId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.phone = phone;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
