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

    public PatientDto addPatient(PatientDto patientDto) {
        return PatientMapper.toDto(
            patientRepository.save(
                PatientMapper.toEntity(patientDto)
            )
        );
    }

    public PatientDto updateById(Long id, PatientDto patientDto) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        patientDto.setId(id);
        return PatientMapper.toDto(
            patientRepository.save(
                PatientMapper.toEntity(patientDto)
            )
        );
    }

    public void removeById(Long id) {
        patientRepository.deleteById(id);
    }

    public PatientDto getById(Long id) {
        return PatientMapper.toDto(
            patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id))
        );
    }
} 