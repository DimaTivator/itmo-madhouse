package org.dimativator.itmomadhouse.rest.impl;

import org.dimativator.itmomadhouse.rest.DischargeReportApi;
import org.dimativator.itmomadhouse.services.DischargeReportService;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.dimativator.itmomadhouse.dto.DischargePatientRequest;

@RestController
@RequiredArgsConstructor
public class DischargeReportApiImpl implements DischargeReportApi {
    private final DischargeReportService dischargeReportService;

    @Override
    public ResponseEntity<Void> dischargePatient(DischargePatientRequest request) {
        dischargeReportService.dischargePatient(request);
        return ResponseEntity.ok().build();
    }
}
