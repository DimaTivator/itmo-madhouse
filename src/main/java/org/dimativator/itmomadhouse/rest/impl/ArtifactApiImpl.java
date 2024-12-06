package org.dimativator.itmomadhouse.rest.impl;

import org.dimativator.itmomadhouse.rest.ArtifactApi;
import org.dimativator.itmomadhouse.dto.ArtifactDto;
import org.dimativator.itmomadhouse.services.ArtifactService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
public class ArtifactApiImpl implements ArtifactApi {

    private final ArtifactService artifactService;

    @Autowired
    public ArtifactApiImpl(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @Override
    public ResponseEntity<List<ArtifactDto>> findAll() {
        return ResponseEntity.ok(artifactService.getAllArtifacts());
    }
} 
