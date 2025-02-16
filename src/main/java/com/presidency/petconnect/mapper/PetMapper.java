package com.presidency.petconnect.mapper;

import com.presidency.petconnect.dto.PetDto;
import com.presidency.petconnect.entity.Pet;

public class PetMapper {

    public static PetDto mapToPetDto(Pet pet) {
        return new PetDto(pet.getPetId(), pet.getShelter(), pet.getName(),
                pet.getBreed(), pet.getAge(), pet.getGender(),
                pet.getDescription(), pet.getPhotos(), pet.getAdoptionStatus(), pet.getPrice(), pet.getCreatedAt());
    }

    public static Pet mapToPet(PetDto petDto) {
        return new Pet(petDto.getPetId(), petDto.getShelter(), petDto.getName(),
                petDto.getBreed(), petDto.getAge(), petDto.getGender(),
                petDto.getDescription(), petDto.getPhotos(), petDto.getAdoptionStatus(),petDto.getPrice());
    }
}
