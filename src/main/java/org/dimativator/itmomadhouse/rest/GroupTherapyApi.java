package org.dimativator.itmomadhouse.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.dimativator.itmomadhouse.dto.GroupTherapyDto;
import java.util.List;

@RequestMapping("/api")
public interface GroupTherapyApi {
    @GetMapping("/group-therapies")
    ResponseEntity<List<GroupTherapyDto>> findAll();
}
