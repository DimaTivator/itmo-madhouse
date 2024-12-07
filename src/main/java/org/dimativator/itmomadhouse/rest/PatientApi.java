package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dimativator.itmomadhouse.dto.PatientDto;
import java.util.List;

@RequestMapping("/api")
public interface PatientApi {
    @GetMapping("/patients")
    ResponseEntity<List<PatientDto>> findAll();

    @GetMapping("/patient/{id}")
    ResponseEntity<PatientDto> getPatient(@PathVariable Long id);

    @PostMapping("/patient")
    ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto patientDto);

    @PutMapping("/patient/{id}")
    ResponseEntity<PatientDto> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto);

    @DeleteMapping("/patient/{id}")
    ResponseEntity<Void> removePatient(@PathVariable Long id);

    @PostMapping("/create-personolized-treatments")
    ResponseEntity<Void> createPersonolizedTreatments(@RequestBody PatientDto patientDto);
} 