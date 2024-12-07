package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.DiseaseApi;
import org.dimativator.itmomadhouse.dto.DiseaseDto;
import org.dimativator.itmomadhouse.services.DiseaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiseaseApiImpl implements DiseaseApi {
    private final DiseaseService diseaseService;

    @Override
    public ResponseEntity<List<DiseaseDto>> findAll() {
        return ResponseEntity.ok(diseaseService.getAllDiseases());
    }
} 