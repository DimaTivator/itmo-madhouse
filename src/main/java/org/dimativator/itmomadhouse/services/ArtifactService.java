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

    public ArtifactDto addArtifact(ArtifactDto artifactDto) {
        return ArtifactMapper.toDto(
            artifactRepository.save(
                ArtifactMapper.toEntity(artifactDto)
            )
        );
    }

    public ArtifactDto updateById(Long id, ArtifactDto artifactDto) {
        if (!artifactRepository.existsById(id)) {
            throw new RuntimeException("Artifact not found with id: " + id);
        }
        artifactDto.setId(id);
        return ArtifactMapper.toDto(
            artifactRepository.save(
                ArtifactMapper.toEntity(artifactDto)
            )
        );
    }

    public void removeById(Long id) {
        artifactRepository.deleteById(id);
    }
}
