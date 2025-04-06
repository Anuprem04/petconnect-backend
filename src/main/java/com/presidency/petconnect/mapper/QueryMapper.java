// src/main/java/com/example/petconnect/mapper/QueryMapper.java
package com.presidency.petconnect.mapper;

import com.presidency.petconnect.dto.QueryDTO;
import com.presidency.petconnect.entity.Query;

public class QueryMapper {

    public static Query toEntity(QueryDTO dto) {
        if (dto == null) return null;
        Query query = new Query();
        query.setQueryId(dto.getQueryId());
        query.setName(dto.getName());
        query.setEmail(dto.getEmail());
        query.setSubject(dto.getSubject());
        query.setMessage(dto.getMessage());
        query.setShelterId(dto.getShelterId());
        return query;
    }

    public static QueryDTO toDto(Query query) {
        if (query == null) return null;
        QueryDTO dto = new QueryDTO();
        dto.setQueryId(query.getQueryId());
        dto.setName(query.getName());
        dto.setEmail(query.getEmail());
        dto.setSubject(query.getSubject());
        dto.setMessage(query.getMessage());
        dto.setShelterId(query.getShelterId());
        return dto;
    }
}
