package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.DoctorApi;
import org.dimativator.itmomadhouse.dto.DoctorDto;
import org.dimativator.itmomadhouse.dto.PatientDto;
import org.dimativator.itmomadhouse.dto.PatientGroupDto;
import org.dimativator.itmomadhouse.services.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DoctorApiImpl implements DoctorApi {
    private final DoctorService doctorService;

    @Override
    public ResponseEntity<List<DoctorDto>> findAll() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @Override
    public ResponseEntity<PatientGroupDto> createPatientGroup(Long doctorId, String specialisation, List<PatientDto> patients) {
        DoctorDto doctor = doctorService.getAllDoctors().stream()
            .filter(d -> d.getId().equals(doctorId))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));

        return ResponseEntity.ok(
            doctorService.createPatientGroup(doctor, patients, specialisation)
        );
    }
} 