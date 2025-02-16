
package com.presidency.petconnect.service.impl;

import com.presidency.petconnect.dto.ShelterDto;
import com.presidency.petconnect.entity.Shelter;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.mapper.ShelterMapper;
import com.presidency.petconnect.repository.ShelterRepository;
import com.presidency.petconnect.service.ShelterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShelterServiceImpl implements ShelterService {

    private final ShelterRepository shelterRepository;

    public ShelterServiceImpl(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    @Override
    public ShelterDto createShelter(ShelterDto shelterDto) {
        Shelter shelter = ShelterMapper.mapToShelter(shelterDto);
        Shelter savedShelter = shelterRepository.save(shelter);
        return ShelterMapper.mapToShelterDto(savedShelter);
    }

    @Override
    public ShelterDto getShelterById(int id) throws ResourceNotFoundException {
        Shelter shelter = shelterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shelter not found"));
        return ShelterMapper.mapToShelterDto(shelter);
    }

    @Override
    public List<ShelterDto> getAllShelters() {
        return shelterRepository.findAll().stream().map(ShelterMapper::mapToShelterDto).collect(Collectors.toList());
    }

    @Override
    public ShelterDto updateShelterById(int id, ShelterDto shelterDto) throws ResourceNotFoundException {
        Shelter shelter = shelterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shelter not found"));
        shelter.setName(shelterDto.getName());
        shelter.setAddress(shelterDto.getAddress());
        shelter.setPhone(shelterDto.getPhone());
        shelter.setContactPerson(shelterDto.getContactPerson());
        Shelter updatedShelter = shelterRepository.save(shelter);
        return ShelterMapper.mapToShelterDto(updatedShelter);
    }

    @Override
    public void deleteShelterById(int id) throws ResourceNotFoundException {
        if (!shelterRepository.existsById(id)) {
            throw new ResourceNotFoundException("Shelter not found");
        }
        shelterRepository.deleteById(id);
    }
}
