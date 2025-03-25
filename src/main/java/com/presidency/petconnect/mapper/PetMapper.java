package com.presidency.petconnect.mapper;

import com.presidency.petconnect.dto.PetDto;
import com.presidency.petconnect.entity.Pet;

public class PetMapper {

    public static PetDto mapToPetDto(Pet pet) {
        PetDto dto = new PetDto();
        dto.setPetId(pet.getPetId());
        dto.setShelterId(pet.getShelter().getShelterId());
        dto.setAnimalType(pet.getAnimalType());
        dto.setBreed(pet.getBreed());
        dto.setAge(pet.getAge());
        dto.setGender(pet.getGender());
        dto.setDescription(pet.getDescription());
        dto.setPhotos(pet.getPhotos());
        dto.setAdoptionStatus(pet.getAdoptionStatus());
        dto.setPrice(pet.getPrice());
        return dto;
    }

    public static Pet mapToPet(PetDto dto) {
        Pet pet = new Pet();
        pet.setPetId(dto.getPetId());
        pet.setAnimalType(dto.getAnimalType());
        pet.setBreed(dto.getBreed());
        pet.setAge(dto.getAge());
        pet.setGender(dto.getGender());
        pet.setDescription(dto.getDescription());
        pet.setPhotos(dto.getPhotos());
        pet.setAdoptionStatus(dto.getAdoptionStatus());
        pet.setPrice(dto.getPrice());
        return pet;
    }

    public static void updatePetFromDto(Pet existing, PetDto dto) {
        if (dto.getAnimalType() != null) existing.setAnimalType(dto.getAnimalType());
        if (dto.getBreed() != null) existing.setBreed(dto.getBreed());
        if ( dto.getAge() > 0) existing.setAge(dto.getAge());
        if (dto.getGender() != null) existing.setGender(dto.getGender());
        if (dto.getDescription() != null) existing.setDescription(dto.getDescription());
        if (dto.getPhotos() != null) existing.setPhotos(dto.getPhotos());
        if (dto.getAdoptionStatus() != null) existing.setAdoptionStatus(dto.getAdoptionStatus());
        if (dto.getPrice() != null) existing.setPrice(dto.getPrice());
    }
}
