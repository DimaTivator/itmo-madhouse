package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.dimativator.itmomadhouse.repository.ArtifactRepository;
import org.dimativator.itmomadhouse.dto.ArtifactDto;
import org.dimativator.itmomadhouse.mappers.ArtifactMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtifactService {
    private final ArtifactRepository artifactRepository;

    public List<ArtifactDto> getAllArtifacts() {
        return artifactRepository.findAll().stream()
            .map(ArtifactMapper::toDto)
            .toList();
    }
}
