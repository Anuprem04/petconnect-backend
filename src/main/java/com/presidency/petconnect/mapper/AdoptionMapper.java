package com.presidency.petconnect.mapper;

import com.presidency.petconnect.dto.AddressDto;
import com.presidency.petconnect.dto.AdoptionDto;
import com.presidency.petconnect.entity.Address;
import com.presidency.petconnect.entity.Adoption;
import com.presidency.petconnect.entity.Pet;
import com.presidency.petconnect.entity.Shelter;
import com.presidency.petconnect.entity.User;

public class AdoptionMapper {
    public static AdoptionDto toDto(Adoption adoption) {
        return new AdoptionDto(
                adoption.getAdoptionId(),
                adoption.getPet().getPetId(),
                adoption.getUser().getUserId(),
                adoption.getShelter().getShelterId(),
                adoption.getApplicationDate(),
                adoption.getApprovalStatus(),
                adoption.getName(),
                adoption.getPhone(),
                adoption.getReason(),
                toAddressDto(adoption.getAddress()),
                adoption.isDeliveryRequested(),
                adoption.isPaymentSuccessful()
        );
    }

    public static Adoption toEntity(AdoptionDto adoptionDto, Pet pet, User user, Shelter shelter) {
        return new Adoption(
                adoptionDto.getAdoptionId(),
                pet,
                user,
                shelter,
                adoptionDto.getApplicationDate(),
                adoptionDto.getApprovalStatus(),
                adoptionDto.getName(),
                adoptionDto.getPhone(),
                adoptionDto.getReason(),
                toAddress(adoptionDto.getAddress()),
                adoptionDto.isDeliveryRequested(),
                adoptionDto.isPaymentSuccessful()
        );
    }

    private static AddressDto toAddressDto(Address address) {
        if (address == null) {
            return null;
        }
        return new AddressDto(
                address.getStreetAddress(),
                address.getCity(),
                address.getState(),
                address.getZipCode()
        );
    }

    private static Address toAddress(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }
        return new Address(
                addressDto.getStreetAddress(),
                addressDto.getCity(),
                addressDto.getState(),
                addressDto.getZipCode()
        );
    }
}
