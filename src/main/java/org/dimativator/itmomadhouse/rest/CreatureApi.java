package org.dimativator.itmomadhouse.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import java.util.List;

import org.dimativator.itmomadhouse.dto.CreatureDto;

@RequestMapping("/api")
public interface CreatureApi {
    
    @GetMapping("/creatures")
    ResponseEntity<List<CreatureDto>> findAll();
}
