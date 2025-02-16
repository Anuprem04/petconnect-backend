
package com.presidency.petconnect.dto;

import java.sql.Timestamp;

public class AdoptionDto {
    private int adoptionId;
    private int petId;
    private int userId;
    private Timestamp applicationDate;
    private String approvalStatus;

    public AdoptionDto() {
    }

    public AdoptionDto(int adoptionId, int petId, int userId, Timestamp applicationDate, String approvalStatus) {
        this.adoptionId = adoptionId;
        this.petId = petId;
        this.userId = userId;
        this.applicationDate = applicationDate;
        this.approvalStatus = approvalStatus;
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
