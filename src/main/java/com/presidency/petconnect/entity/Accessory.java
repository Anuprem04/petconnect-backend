package com.presidency.petconnect.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Accessory {

    @Id
    @SequenceGenerator(name = "accessory_seq", sequenceName = "accessory_sequence", initialValue = 4000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accessory_seq")
    private int accessoryId;
    private String name;
    private String category;
    private String description;
    private double price;
    private String image;
    private Timestamp createdAt;

    public int getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(int accessoryId) {
        this.accessoryId = accessoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
