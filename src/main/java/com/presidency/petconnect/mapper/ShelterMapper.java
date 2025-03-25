package com.presidency.petconnect.mapper;

import com.presidency.petconnect.dto.ShelterDto;
import com.presidency.petconnect.entity.Shelter;

public class ShelterMapper {

    public static ShelterDto mapToShelterDto(Shelter shelter) {
        return new ShelterDto(
                shelter.getShelterId(),
                shelter.getName(),
                shelter.getEmail(),
                shelter.getPassword(),
                shelter.getCity(),
                shelter.getPhone()
        );
    }

    public static Shelter mapToShelter(ShelterDto dto) {
        Shelter shelter = new Shelter();
        shelter.setShelterId(dto.getShelterId());
        shelter.setName(dto.getName());
        shelter.setEmail(dto.getEmail());
        shelter.setPassword(dto.getPassword());
        shelter.setCity(dto.getCity());
        shelter.setPhone(dto.getPhone());
        return shelter;
    }
}
