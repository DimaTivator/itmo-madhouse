package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.PatientGroupApi;
import org.dimativator.itmomadhouse.dto.PatientGroupDto;
import org.dimativator.itmomadhouse.services.PatientGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientGroupApiImpl implements PatientGroupApi {
    private final PatientGroupService patientGroupService;

    @Override
    public ResponseEntity<List<PatientGroupDto>> findAll() {
        return ResponseEntity.ok(patientGroupService.getAllPatientGroups());
    }
} 