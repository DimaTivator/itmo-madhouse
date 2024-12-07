package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dimativator.itmomadhouse.dto.DischargeReportDto;
import org.dimativator.itmomadhouse.dto.DischargePatientRequest;
import java.util.List;

@RequestMapping("/api")
public interface DischargeReportApi {
    @GetMapping("/discharge-reports")
    ResponseEntity<List<DischargeReportDto>> findAll();

    @PutMapping("/discharge-report/{id}")
    ResponseEntity<DischargeReportDto> updateDischargeReport(@PathVariable Long id, @RequestBody DischargeReportDto reportDto);

    @DeleteMapping("/discharge-report/{id}")
    ResponseEntity<Void> removeDischargeReport(@PathVariable Long id);

    @PostMapping("/discharge")
    ResponseEntity<Void> dischargePatient(@RequestBody DischargePatientRequest request);
}
