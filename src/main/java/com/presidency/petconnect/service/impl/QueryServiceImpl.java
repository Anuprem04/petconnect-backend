// src/main/java/com/example/petconnect/service/impl/QueryServiceImpl.java
package com.presidency.petconnect.service.impl;


import com.presidency.petconnect.dto.QueryDTO;
import com.presidency.petconnect.entity.Query;
import com.presidency.petconnect.mapper.QueryMapper;
import com.presidency.petconnect.repository.QueryRepository;
import com.presidency.petconnect.service.QueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class QueryServiceImpl implements QueryService {

    private final QueryRepository queryRepository;

    public QueryServiceImpl(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    @Override
    public QueryDTO createQuery(QueryDTO queryDTO) {
        Query query = QueryMapper.toEntity(queryDTO);
        Query saved = queryRepository.save(query);
        return QueryMapper.toDto(saved);
    }

    @Override
    public List<QueryDTO> getAllQueries() {
        List<Query> queries = queryRepository.findAll();
        return queries.stream()
                .map(QueryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<QueryDTO> getAllQueriesByShelterId(int id) {
        List<Query> queries = queryRepository.findByShelterId(id);
        return queries.stream()
                .map(QueryMapper::toDto)
                .collect(Collectors.toList());
    }

}
