
package com.presidency.petconnect.service;

import com.presidency.petconnect.dto.ShelterDto;
import com.presidency.petconnect.exception.ResourceNotFoundException;

import java.util.List;

public interface ShelterService {
    ShelterDto createShelter(ShelterDto shelterDto);
    ShelterDto getShelterById(int id) throws ResourceNotFoundException;
    List<ShelterDto> getAllShelters();
    ShelterDto updateShelterById(int id, ShelterDto shelterDto) throws ResourceNotFoundException;
    void deleteShelterById(int id) throws ResourceNotFoundException;
}
