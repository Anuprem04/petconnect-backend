package com.presidency.petconnect.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.presidency.petconnect.entity.Shelter;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;

public class PetDto {


    private int petId;


    private Integer shelterId;

    private String animalType;
    private String breed;
    private int age;
    private String gender;
    private String description;
    private String photos;
    private String adoptionStatus;
    private Double price;
    private List<MultipartFile> photoFiles;


    public PetDto() {
    }

    public PetDto(int petId, Integer shelterId, String animalType, String breed, int age, String gender, String description, String photos, String adoptionStatus, Double price, List<MultipartFile> photoFiles) {
        this.petId = petId;
        this.shelterId = shelterId;
        this.animalType = animalType;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.photos = photos;
        this.adoptionStatus = adoptionStatus;
        this.price = price;
        this.photoFiles = photoFiles;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public Integer getShelterId() {
        return shelterId;
    }

    public void setShelterId(Integer shelterId) {
        this.shelterId = shelterId;
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

    public List<MultipartFile> getPhotoFiles() {
        return photoFiles;
    }

    public void setPhotoFiles(List<MultipartFile> photoFiles) {
        this.photoFiles = photoFiles;
    }
}