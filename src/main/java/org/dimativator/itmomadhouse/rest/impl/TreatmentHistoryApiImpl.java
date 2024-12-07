package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.TreatmentHistoryApi;
import org.dimativator.itmomadhouse.dto.TreatmentHistoryDto;
import org.dimativator.itmomadhouse.services.TreatmentHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TreatmentHistoryApiImpl implements TreatmentHistoryApi {
    private final TreatmentHistoryService treatmentHistoryService;

    @Override
    public ResponseEntity<List<TreatmentHistoryDto>> findAll() {
        return ResponseEntity.ok(treatmentHistoryService.getAllTreatmentHistories());
    }
}
