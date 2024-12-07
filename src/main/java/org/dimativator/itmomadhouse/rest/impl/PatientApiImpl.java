package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.PatientApi;
import org.dimativator.itmomadhouse.dto.PatientDto;
import org.dimativator.itmomadhouse.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientApiImpl implements PatientApi {
    private final PatientService patientService;

    @Override
    public ResponseEntity<List<PatientDto>> findAll() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }
} 