package com.presidency.petconnect.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Pet {
    @Id
    @SequenceGenerator(name = "pet_seq", sequenceName = "pet_sequence", initialValue = 3000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    private int petId;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    @JsonBackReference
    private Shelter shelter;

    private String animalType;
    private String breed;
    private int age;
    private String gender;
    private String description;
    private String photos;
    private String adoptionStatus;
    private Double price;


    public Pet() {
    }

    public Pet(int petId, Shelter shelter, String animalType, String breed, int age, String gender, String description, String photos, String adoptionStatus, Double price) {
        this.petId = petId;
        this.shelter = shelter;
        this.animalType = animalType;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.photos = photos;
        this.adoptionStatus = adoptionStatus;
        this.price = price;

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

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
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


}
