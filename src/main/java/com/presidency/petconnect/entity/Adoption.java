package com.presidency.petconnect.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;

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

    private Timestamp applicationDate;
    private String approvalStatus;

    public Adoption() {
    }

    public Adoption(int adoptionId, Pet pet, User user, Timestamp applicationDate, String approvalStatus) {
        this.adoptionId = adoptionId;
        this.pet = pet;
        this.user = user;
        this.applicationDate = applicationDate;
        this.approvalStatus = approvalStatus;
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

    public Timestamp getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Timestamp applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

}
