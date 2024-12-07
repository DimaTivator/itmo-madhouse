package org.dimativator.itmomadhouse.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.dimativator.itmomadhouse.dto.TreatmentHistoryDto;
import java.util.List;

@RequestMapping("/api")
public interface TreatmentHistoryApi {
    @GetMapping("/treatment-histories")
    ResponseEntity<List<TreatmentHistoryDto>> findAll();
}
