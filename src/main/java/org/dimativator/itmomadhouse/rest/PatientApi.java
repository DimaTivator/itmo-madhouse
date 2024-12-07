package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.dimativator.itmomadhouse.dto.PatientDto;
import java.util.List;

@RequestMapping("/api")
public interface PatientApi {
    @GetMapping("/patients")
    ResponseEntity<List<PatientDto>> findAll();
} 