package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dimativator.itmomadhouse.dto.DoctorDto;
import org.dimativator.itmomadhouse.dto.PatientDto;
import org.dimativator.itmomadhouse.dto.PatientGroupDto;
import java.util.List;

@RequestMapping("/api")
public interface DoctorApi {
    @GetMapping("/doctors")
    ResponseEntity<List<DoctorDto>> findAll();

    @PostMapping("/doctors/{doctorId}/create-group")
    ResponseEntity<PatientGroupDto> createPatientGroup(
        @PathVariable Long doctorId,
        @RequestParam String specialisation,
        @RequestBody List<PatientDto> patients
    );
} 