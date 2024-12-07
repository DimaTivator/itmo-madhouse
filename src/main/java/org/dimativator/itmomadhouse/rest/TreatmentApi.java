package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.dimativator.itmomadhouse.dto.TreatmentDto;
import org.dimativator.itmomadhouse.dto.AssignTherapyRequest;
import java.util.List;

@RequestMapping("/api")
public interface TreatmentApi {
    @GetMapping("/treatments")
    ResponseEntity<List<TreatmentDto>> findAll();

    @PostMapping("/treatments/assign")
    ResponseEntity<Void> assignTherapy(@RequestBody AssignTherapyRequest request);
} 