
package com.presidency.petconnect.dto;

public class ShelterDto {
    private int shelterId;
    private String name;
    private String address;
    private String phone;
    private String contactPerson;


    public ShelterDto() {}

    public ShelterDto(int shelterId, String name, String address, String phone, String contactPerson) {
        this.shelterId = shelterId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.contactPerson = contactPerson;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}
