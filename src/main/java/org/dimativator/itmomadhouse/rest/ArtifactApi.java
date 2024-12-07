package org.dimativator.itmomadhouse.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.dimativator.itmomadhouse.dto.ArtifactDto;
import java.util.List;

@RequestMapping("/api")  
public interface ArtifactApi {
    @GetMapping("/artifacts")
    ResponseEntity<List<ArtifactDto>> findAll();

    @PostMapping("/artifact")
    ResponseEntity<ArtifactDto> addArtifact(@RequestBody ArtifactDto artifactDto);

    @PutMapping("/artifact/{id}")
    ResponseEntity<ArtifactDto> updateArtifact(@PathVariable Long id, @RequestBody ArtifactDto artifactDto);

    @DeleteMapping("/artifact/{id}")
    ResponseEntity<Void> removeArtifact(@PathVariable Long id);
}
