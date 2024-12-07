package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.DoctorApi;
import org.dimativator.itmomadhouse.dto.DoctorDto;
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
} 