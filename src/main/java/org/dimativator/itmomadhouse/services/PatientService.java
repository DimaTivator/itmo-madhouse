package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.dto.PatientDto;
import org.dimativator.itmomadhouse.repository.PatientRepository;
import org.dimativator.itmomadhouse.mappers.PatientMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll().stream()
            .map(PatientMapper::toDto)
            .toList();
    }
} 