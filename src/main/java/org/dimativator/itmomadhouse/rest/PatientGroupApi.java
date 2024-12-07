package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dimativator.itmomadhouse.dto.PatientGroupDto;
import java.util.List;

@RequestMapping("/api")
public interface PatientGroupApi {
    @GetMapping("/patient-groups")
    ResponseEntity<List<PatientGroupDto>> findAll();

    @GetMapping("/patient-group/{id}")
    ResponseEntity<PatientGroupDto> getPatientGroup(@PathVariable Long id);

    @PostMapping("/patient-group")
    ResponseEntity<PatientGroupDto> addPatientGroup(@RequestBody PatientGroupDto groupDto);

    @PutMapping("/patient-group/{id}")
    ResponseEntity<PatientGroupDto> updatePatientGroup(@PathVariable Long id, @RequestBody PatientGroupDto groupDto);

    @DeleteMapping("/patient-group/{id}")
    ResponseEntity<Void> removePatientGroup(@PathVariable Long id);
} 