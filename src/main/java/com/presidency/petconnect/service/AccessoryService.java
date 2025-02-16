
package com.presidency.petconnect.service;

import com.presidency.petconnect.dto.AccessoryDto;
import com.presidency.petconnect.exception.ResourceNotFoundException;

import java.util.List;

public interface AccessoryService {
    AccessoryDto createAccessory(AccessoryDto accessoryDto);
    AccessoryDto getAccessoryById(int id) throws ResourceNotFoundException;
    List<AccessoryDto> getAllAccessories();
    AccessoryDto updateAccessory(int id, AccessoryDto accessoryDto) throws ResourceNotFoundException;
    String deleteAccessory(int id) throws ResourceNotFoundException;
}
