package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.dimativator.itmomadhouse.dto.ArtifactDto;
import java.util.List;

@RequestMapping("/api")  
public interface ArtifactApi {
    @GetMapping("/artifacts")
    ResponseEntity<List<ArtifactDto>> findAll();
}
