package com.presidency.petconnect.service.impl;

import com.presidency.petconnect.dto.AdoptionDto;
import com.presidency.petconnect.dto.PetDto;
import com.presidency.petconnect.entity.Pet;
import com.presidency.petconnect.entity.Shelter;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.mapper.PetMapper;
import com.presidency.petconnect.repository.PetRepository;
import com.presidency.petconnect.repository.ShelterRepository;
import com.presidency.petconnect.service.PetService;
import com.presidency.petconnect.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final ShelterRepository shelterRepository;
    private final StorageService storageService;

    public PetServiceImpl(PetRepository petRepository, ShelterRepository shelterRepository, StorageService storageService) {
        this.petRepository = petRepository;
        this.shelterRepository = shelterRepository;
        this.storageService = storageService;
    }

    @Override
    public PetDto createPetForShelter(Integer shelterId, PetDto dto) throws ResourceNotFoundException {
        Shelter shelter = shelterRepository.findById(shelterId)
                .orElseThrow(() -> new ResourceNotFoundException("Shelter not found"));
        Pet pet = PetMapper.mapToPet(dto);
        pet.setShelter(shelter);

        String photos = dto.getPhotoFiles().stream()
                .peek(file -> {
                    String contentType = file.getContentType();
                    System.out.println("Content-Type: " + contentType);

                    if (contentType == null ||
                            !(contentType.equalsIgnoreCase("image/jpeg") ||
                                    contentType.equalsIgnoreCase("image/jpg") ||
                                    contentType.equalsIgnoreCase("image/png") ||
                                    contentType.equalsIgnoreCase("image/avif"))) {
                        throw new IllegalArgumentException("Only JPEG/JPG/AVIF/PNG are allowed");
                    }
                })
                .map(storageService::store)
                .collect(Collectors.joining(","));
        pet.setPhotos(photos);

        return PetMapper.mapToPetDto(petRepository.save(pet));
    }

    @Override
    public List<PetDto> getAllByShelterId(Integer shelterId) {
        return petRepository.findByShelter_ShelterId(shelterId).stream()
                .map(PetMapper::mapToPetDto)
                .collect(Collectors.toList());
    }

    @Override
    public PetDto getByIdAndShelter(Integer id, Integer shelterId) throws ResourceNotFoundException {
        return PetMapper.mapToPetDto(
                petRepository.findByPetIdAndShelter_ShelterId(id, shelterId)
                        .orElseThrow(() -> new ResourceNotFoundException("Pet not found"))
        );
    }

    @Override
    public PetDto updatePetForShelter(Integer id, Integer shelterId, PetDto petDto) throws ResourceNotFoundException {
        Pet existing = petRepository.findByPetIdAndShelter_ShelterId(id, shelterId)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found"));
        PetMapper.updatePetFromDto(existing, petDto);
        return PetMapper.mapToPetDto(petRepository.save(existing));
    }

    @Override
    public void deletePetForShelter(Integer id, Integer shelterId) throws ResourceNotFoundException {
        if (!petRepository.existsByPetIdAndShelter_ShelterId(id, shelterId)) {
            throw new ResourceNotFoundException("Pet not found");
        }
        petRepository.deleteById(id);
    }

    @Override
    public List<PetDto> getAllPets() {
        return petRepository.findAll().stream().map(PetMapper::mapToPetDto).collect(Collectors.toList());
    }

    @Override
    public PetDto getPetById(int id) throws ResourceNotFoundException {
        Pet pet = petRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Pet Not Found"));
        return PetMapper.mapToPetDto(pet);
    }

}
