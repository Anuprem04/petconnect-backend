
package com.presidency.petconnect.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Locale;

public class AdoptionDto {
    private int adoptionId;
    private int petId;
    private int userId;
    private LocalDate applicationDate;
    private String approvalStatus;
    private String name;
    private String phone;
    private String reason;
    public AdoptionDto() {
    }

    public AdoptionDto(int adoptionId, int petId, int userId, LocalDate applicationDate, String approvalStatus, String name, String phone, String reason) {
        this.adoptionId = adoptionId;
        this.petId = petId;
        this.userId = userId;
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
