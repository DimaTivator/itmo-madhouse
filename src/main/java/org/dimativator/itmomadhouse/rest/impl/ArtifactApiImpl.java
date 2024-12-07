package org.dimativator.itmomadhouse.rest.impl;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.rest.ArtifactApi;
import org.dimativator.itmomadhouse.dto.ArtifactDto;
import org.dimativator.itmomadhouse.services.ArtifactService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArtifactApiImpl implements ArtifactApi {

    private final ArtifactService artifactService;

    @Override
    public ResponseEntity<List<ArtifactDto>> findAll() {
        return ResponseEntity.ok(artifactService.getAllArtifacts());
    }
} 
