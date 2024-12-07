package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.dimativator.itmomadhouse.dto.DischargePatientRequest;

@RequestMapping("/api")
public interface DischargeReportApi {
    @PostMapping("/discharge")
    ResponseEntity<Void> dischargePatient(@RequestBody DischargePatientRequest request);
}
