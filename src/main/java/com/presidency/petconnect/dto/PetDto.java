package com.presidency.petconnect.dto;

import com.presidency.petconnect.entity.Shelter;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

public class PetDto {

    private int petId;
    private Shelter shelter;
    private String name;
    private String breed;
    private int age;
    private String gender;
    private String description;
    private String photos;
    private String adoptionStatus;
    private Double price;
    private Timestamp createdAt;

    public PetDto() {
    }

    public PetDto(int petId, Shelter shelter, String name, String breed, int age, String gender, String description, String photos, String adoptionStatus, Double price, Timestamp createdAt) {
        this.petId = petId;
        this.shelter = shelter;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.photos = photos;
        this.adoptionStatus = adoptionStatus;
        this.price = price;
        this.createdAt = createdAt;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
