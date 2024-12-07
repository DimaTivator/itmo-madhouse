package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.PatientApi;
import org.dimativator.itmomadhouse.dto.PatientDto;
import org.dimativator.itmomadhouse.services.PatientService;
import org.dimativator.itmomadhouse.services.TreatmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientApiImpl implements PatientApi {
    private final PatientService patientService;
    private final TreatmentService treatmentService;

    @Override
    public ResponseEntity<List<PatientDto>> findAll() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @Override
    public ResponseEntity<PatientDto> getPatient(Long id) {
        return ResponseEntity.ok(patientService.getById(id));
    }

    @Override
    public ResponseEntity<PatientDto> addPatient(PatientDto patientDto) {
        return ResponseEntity.ok(patientService.addPatient(patientDto));
    }

    @Override
    public ResponseEntity<PatientDto> updatePatient(Long id, PatientDto patientDto) {
        return ResponseEntity.ok(patientService.updateById(id, patientDto));
    }

    @Override
    public ResponseEntity<Void> removePatient(Long id) {
        patientService.removeById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> createPersonolizedTreatments(PatientDto patientDto) {
        treatmentService.createPersonolizedTreatments(patientDto);
        return ResponseEntity.ok().build();
    }
} 