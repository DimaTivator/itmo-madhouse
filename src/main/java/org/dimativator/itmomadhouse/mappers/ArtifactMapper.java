package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.ArtifactDto;
import org.dimativator.itmomadhouse.model.Artifact;

public class ArtifactMapper {
    public static Artifact toEntity(ArtifactDto artifactDto) {
        return Artifact.builder()
                .id(artifactDto.getId())
                .name(artifactDto.getName())
                .effect(artifactDto.getEffect())
                .build();
    }

    public static ArtifactDto toDto(Artifact artifact) {
        return ArtifactDto.builder()
                .id(artifact.getId())
                .name(artifact.getName())
                .effect(artifact.getEffect())
                .build();
    }
}
