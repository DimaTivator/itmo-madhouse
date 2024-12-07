package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.dto.DiseaseDto;
import org.dimativator.itmomadhouse.repository.DiseaseRepository;
import org.dimativator.itmomadhouse.mappers.DiseaseMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiseaseService {
    private final DiseaseRepository diseaseRepository;

    public List<DiseaseDto> getAllDiseases() {
        return diseaseRepository.findAll().stream()
            .map(DiseaseMapper::toDto)
            .toList();
    }
} 