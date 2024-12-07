package org.dimativator.itmomadhouse.rest.impl;

import org.dimativator.itmomadhouse.rest.DischargeReportApi;
import org.dimativator.itmomadhouse.services.DischargeReportService;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.dimativator.itmomadhouse.dto.DischargePatientRequest;
import org.dimativator.itmomadhouse.dto.DischargeReportDto;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DischargeReportApiImpl implements DischargeReportApi {
    private final DischargeReportService dischargeReportService;

    @Override
    public ResponseEntity<List<DischargeReportDto>> findAll() {
        return ResponseEntity.ok(dischargeReportService.getAllDischargeReports());
    }
    
    @Override
    public ResponseEntity<DischargeReportDto> updateDischargeReport(Long id, DischargeReportDto reportDto) {
        return ResponseEntity.ok(dischargeReportService.updateById(id, reportDto));
    }

    @Override
    public ResponseEntity<Void> removeDischargeReport(Long id) {
        dischargeReportService.removeById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> dischargePatient(DischargePatientRequest request) {
        dischargeReportService.dischargePatient(request);
        return ResponseEntity.ok().build();
    }
}
