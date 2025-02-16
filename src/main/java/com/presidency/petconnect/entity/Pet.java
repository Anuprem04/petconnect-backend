package com.presidency.petconnect.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
@Entity
public class Pet {
    @Id
    @SequenceGenerator(name = "pet_seq", sequenceName = "pet_sequence", initialValue = 3000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private int petId;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;
    private String name;
    private String breed;
    private int age;
    private String gender;
    private String description;
    private String photos;
    private String adoptionStatus;
    private Timestamp createdAt;

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
