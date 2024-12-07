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
    public ResponseEntity<Void> assignTherapy(AssignTherapyRequest request) {
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Assigning therapy to patient " + request.getPatientId());
        System.out.println("Doctor ID: " + request.getDoctorId());
        System.out.println("Artifact ID: " + request.getArtifactId());
        System.out.println("Spell ID: " + request.getSpellId());
        System.out.println("Creature ID: " + request.getCreatureId());
        System.out.println("Treatment date: " + request.getTreatmentDate());
        System.out.println("------------------------------------------------------------------------------------------------------");
        treatmentService.assignTherapy(request);
        return ResponseEntity.ok().build();
    }
} 