package com.presidency.petconnect.mapper;

import com.presidency.petconnect.dto.AdoptionDto;
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
                adoption.getReason()
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
                adoptionDto.getReason()
        );
    }
}
