package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.DiseaseDto;
import org.dimativator.itmomadhouse.model.Disease;

public class DiseaseMapper {
    public static Disease toEntity(DiseaseDto diseaseDto) {
        return Disease.builder()
                .id(diseaseDto.getId())
                .name(diseaseDto.getName())
                .description(diseaseDto.getDescription())
                .build();
    }

    public static DiseaseDto toDto(Disease disease) {
        return DiseaseDto.builder()
                .id(disease.getId())
                .name(disease.getName())
                .description(disease.getDescription())
                .build();
    }
} 