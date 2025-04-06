// src/main/java/com/example/petconnect/service/QueryService.java
package com.presidency.petconnect.service;

import com.presidency.petconnect.dto.QueryDTO;

import java.util.List;

public interface QueryService {
    QueryDTO createQuery(QueryDTO queryDTO);
    List<QueryDTO> getAllQueries();

    List<QueryDTO> getAllQueriesByShelterId(int id);
}
