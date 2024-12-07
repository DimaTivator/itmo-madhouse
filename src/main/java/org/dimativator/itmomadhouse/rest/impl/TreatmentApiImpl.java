package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.TreatmentApi;
import org.dimativator.itmomadhouse.dto.TreatmentDto;
import org.dimativator.itmomadhouse.dto.AssignTherapyRequest;
import org.dimativator.itmomadhouse.services.TreatmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TreatmentApiImpl implements TreatmentApi {
    private final TreatmentService treatmentService;

    @Override
    public ResponseEntity<List<TreatmentDto>> findAll() {
        return ResponseEntity.ok(treatmentService.getAllTreatments());
    }

    @Override
    public ResponseEntity<TreatmentDto> getTreatment(Long id) {
        return ResponseEntity.ok(treatmentService.getById(id));
    }

    @Override
    public ResponseEntity<TreatmentDto> addTreatment(TreatmentDto treatmentDto) {
        return ResponseEntity.ok(treatmentService.addTreatment(treatmentDto));
    }

    @Override
    public ResponseEntity<TreatmentDto> updateTreatment(Long id, TreatmentDto treatmentDto) {
        return ResponseEntity.ok(treatmentService.updateById(id, treatmentDto));
    }

    @Override
    public ResponseEntity<Void> removeTreatment(Long id) {
        treatmentService.removeById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> assignTherapy(AssignTherapyRequest request) {
        treatmentService.assignTherapy(request);
        return ResponseEntity.ok().build();
    }
} 