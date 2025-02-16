
package com.presidency.petconnect.service.impl;

import com.presidency.petconnect.dto.AccessoryDto;
import com.presidency.petconnect.entity.Accessory;
import com.presidency.petconnect.exception.ResourceNotFoundException;
import com.presidency.petconnect.mapper.AccessoryMapper;
import com.presidency.petconnect.repository.AccessoryRepository;
import com.presidency.petconnect.service.AccessoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessoryServiceImpl implements AccessoryService {

    private final AccessoryRepository repository;

    public AccessoryServiceImpl(AccessoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public AccessoryDto createAccessory(AccessoryDto accessoryDto) {
        Accessory accessory = AccessoryMapper.toEntity(accessoryDto);
        Accessory saved = repository.save(accessory);
        return AccessoryMapper.toDto(saved);
    }

    @Override
    public AccessoryDto getAccessoryById(int id) throws ResourceNotFoundException {
        Accessory accessory = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Accessory not found"));
        return AccessoryMapper.toDto(accessory);
    }

    @Override
    public List<AccessoryDto> getAllAccessories() {
        return repository.findAll().stream().map(AccessoryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AccessoryDto updateAccessory(int id, AccessoryDto accessoryDto) throws ResourceNotFoundException {
        Accessory accessory = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Accessory not found"));
        accessory.setName(accessoryDto.getName());
        accessory.setCategory(accessoryDto.getCategory());
        accessory.setDescription(accessoryDto.getDescription());
        accessory.setPrice(accessoryDto.getPrice());
        accessory.setImage(accessoryDto.getImage());
        Accessory updated = repository.save(accessory);
        return AccessoryMapper.toDto(updated);
    }

    @Override
    public String deleteAccessory(int id) throws ResourceNotFoundException {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Accessory not found");
        }
        repository.deleteById(id);
        return "Accessory with id "+id+" deleted successfully";
    }
}
