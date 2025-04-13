package com.presidency.petconnect.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    private LocalDate applicationDate;
    private String approvalStatus;
    private String name;
    private String phone;
    private String reason;

    @Embedded
    private Address address;

    private boolean isDeliveryRequested;
    private boolean isPaymentSuccessful;
    public Adoption() {
    }

    public Adoption(int adoptionId, Pet pet, User user, Shelter shelter, LocalDate applicationDate, String approvalStatus, String name, String phone, String reason, Address address, boolean isDeliveryRequested, boolean isPaymentSuccessful) {
        this.adoptionId = adoptionId;
        this.pet = pet;
        this.user = user;
        this.shelter = shelter;
        this.applicationDate = applicationDate;
        this.approvalStatus = approvalStatus;
        this.name = name;
        this.phone = phone;
        this.reason = reason;
        this.address = address;
        this.isDeliveryRequested = isDeliveryRequested;
        this.isPaymentSuccessful = isPaymentSuccessful;
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

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isDeliveryRequested() {
        return isDeliveryRequested;
    }

    public void setDeliveryRequested(boolean deliveryRequested) {
        isDeliveryRequested = deliveryRequested;
    }

    public boolean isPaymentSuccessful() {
        return isPaymentSuccessful;
    }

    public void setPaymentSuccessful(boolean paymentSuccessful) {
        isPaymentSuccessful = paymentSuccessful;
    }
}
