package com.presidency.petconnect.dto;

import java.time.LocalDate;

public class AdoptionDto {
    private int adoptionId;
    private int petId;
    private int userId;
    private int shelterId;
    private LocalDate applicationDate;
    private String approvalStatus;
    private String name;
    private String phone;
    private String reason;
    private AddressDto address;

    private boolean isDeliveryRequested;
    private boolean isPaymentSuccessful;
    public AdoptionDto() {
    }

    public AdoptionDto(int adoptionId, int petId, int userId, int shelterId, LocalDate applicationDate, String approvalStatus, String name, String phone, String reason, AddressDto address, boolean isDeliveryRequested, boolean isPaymentSuccessful) {
        this.adoptionId = adoptionId;
        this.petId = petId;
        this.userId = userId;
        this.shelterId = shelterId;
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

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
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

    @Override
    public String toString() {
        return "AdoptionDto{" +
                "adoptionId=" + adoptionId +
                ", petId=" + petId +
                ", userId=" + userId +
                ", shelterId=" + shelterId +
                ", applicationDate=" + applicationDate +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", reason='" + reason + '\'' +
                ", address=" + address +
                ", isDeliveryRequested=" + isDeliveryRequested +
                ", isPaymentSuccessful=" + isPaymentSuccessful +
                '}';
    }
}
