
package com.presidency.petconnect.mapper;

import com.presidency.petconnect.dto.AccessoryDto;
import com.presidency.petconnect.entity.Accessory;

public class AccessoryMapper {
    public static AccessoryDto toDto(Accessory accessory) {
        return new AccessoryDto(accessory.getAccessoryId(), accessory.getName(), accessory.getCategory(), accessory.getDescription(), accessory.getPrice(), accessory.getImage());
    }

    public static Accessory toEntity(AccessoryDto dto) {
        return new Accessory(dto.getAccessoryId(), dto.getName(), dto.getCategory(), dto.getDescription(), dto.getPrice(), dto.getImage());
    }
}
