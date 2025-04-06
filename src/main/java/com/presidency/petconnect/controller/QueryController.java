package com.presidency.petconnect.controller;

import com.presidency.petconnect.dto.QueryDTO;
import com.presidency.petconnect.service.QueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/petConnect/queries")
public class QueryController {

    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping
    public ResponseEntity<QueryDTO> createQuery(@RequestBody QueryDTO queryDTO) {
        QueryDTO created = queryService.createQuery(queryDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QueryDTO>> getAllQueries() {
        List<QueryDTO> queries = queryService.getAllQueries();
        return new ResponseEntity<>(queries, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<QueryDTO>> getAllQueriesByShelterId( @AuthenticationPrincipal Jwt jwt) {
        Long shelterId = jwt.getClaim("id");
        List<QueryDTO> queries = queryService.getAllQueriesByShelterId(shelterId.intValue());
        return new ResponseEntity<>(queries, HttpStatus.OK);
    }
}
