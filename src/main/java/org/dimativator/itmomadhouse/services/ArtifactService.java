package org.dimativator.itmomadhouse.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.dimativator.itmomadhouse.repository.ArtifactRepository;
import org.dimativator.itmomadhouse.dto.ArtifactDto;
import org.dimativator.itmomadhouse.mappers.ArtifactMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtifactService {
    private final ArtifactRepository artifactRepository;

    @Autowired
    public ArtifactService(ArtifactRepository artifactRepository) {
        this.artifactRepository = artifactRepository;
    }

    public List<ArtifactDto> getAllArtifacts() {
        return artifactRepository.findAll().stream()
            .map(ArtifactMapper::toDto)
            .collect(Collectors.toList());
    }
}
