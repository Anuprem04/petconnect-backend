
package com.presidency.petconnect.mapper;

import com.presidency.petconnect.dto.ShelterDto;
import com.presidency.petconnect.entity.Shelter;

public class ShelterMapper {

    public static ShelterDto mapToShelterDto(Shelter shelter) {
        return new ShelterDto(
                shelter.getShelterId(),
                shelter.getName(),
                shelter.getAddress(),
                shelter.getPhone(),
                shelter.getContactPerson()
        );
    }

    public static Shelter mapToShelter(ShelterDto dto) {
        Shelter shelter = new Shelter();
        shelter.setShelterId(dto.getShelterId());
        shelter.setName(dto.getName());
        shelter.setAddress(dto.getAddress());
        shelter.setPhone(dto.getPhone());
        shelter.setContactPerson(dto.getContactPerson());
        return shelter;
    }
}
