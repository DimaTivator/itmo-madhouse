package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dimativator.itmomadhouse.dto.TreatmentDto;
import org.dimativator.itmomadhouse.dto.AssignTherapyRequest;
import java.util.List;

@RequestMapping("/api")
public interface TreatmentApi {
    @GetMapping("/treatments")
    ResponseEntity<List<TreatmentDto>> findAll();

    @GetMapping("/treatment/{id}")
    ResponseEntity<TreatmentDto> getTreatment(@PathVariable Long id);

    @PostMapping("/treatment")
    ResponseEntity<TreatmentDto> addTreatment(@RequestBody TreatmentDto treatmentDto);

    @PutMapping("/treatment/{id}")
    ResponseEntity<TreatmentDto> updateTreatment(@PathVariable Long id, @RequestBody TreatmentDto treatmentDto);

    @DeleteMapping("/treatment/{id}")
    ResponseEntity<Void> removeTreatment(@PathVariable Long id);

    @PostMapping("/treatments/assign")
    ResponseEntity<Void> assignTherapy(@RequestBody AssignTherapyRequest request);
} 