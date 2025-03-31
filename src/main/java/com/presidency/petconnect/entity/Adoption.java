package com.presidency.petconnect.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Entity
public class Adoption {
    @Id
    @SequenceGenerator(name = "adoption_seq", sequenceName = "adoption_sequence", initialValue = 4000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adoption_seq")
    private int adoptionId;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate applicationDate;
    private String approvalStatus;

    private String name;
    private String phone;
    private String reason;

    public Adoption() {
    }

    public Adoption(int adoptionId, Pet pet, User user, LocalDate applicationDate, String approvalStatus, String name, String phone, String reason) {
        this.adoptionId = adoptionId;
        this.pet = pet;
        this.user = user;
        this.applicationDate = applicationDate;
        this.approvalStatus = approvalStatus;
        this.name = name;
        this.phone = phone;
        this.reason = reason;
    }

    public int getAdoptionId() {
        return adoptionId;
    }

    public void setAdoptionId(int adoptionId) {
        this.adoptionId = adoptionId;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
