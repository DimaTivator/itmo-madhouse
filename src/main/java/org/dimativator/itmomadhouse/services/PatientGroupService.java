package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.dto.PatientGroupDto;
import org.dimativator.itmomadhouse.repository.PatientGroupRepository;
import org.dimativator.itmomadhouse.mappers.PatientGroupMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientGroupService {
    private final PatientGroupRepository patientGroupRepository;

    public List<PatientGroupDto> getAllPatientGroups() {
        return patientGroupRepository.findAll().stream()
            .map(PatientGroupMapper::toDto)
            .toList();
    }

    public PatientGroupDto addPatientGroup(PatientGroupDto groupDto) {
        return PatientGroupMapper.toDto(
            patientGroupRepository.save(
                PatientGroupMapper.toEntity(groupDto)
            )
        );
    }

    public PatientGroupDto updateById(Long id, PatientGroupDto groupDto) {
        if (!patientGroupRepository.existsById(id)) {
            throw new RuntimeException("Patient group not found with id: " + id);
        }
        groupDto.setId(id);
        return PatientGroupMapper.toDto(
            patientGroupRepository.save(
                PatientGroupMapper.toEntity(groupDto)
            )
        );
    }

    public void removeById(Long id) {
        patientGroupRepository.deleteById(id);
    }

    public PatientGroupDto getById(Long id) {
        return PatientGroupMapper.toDto(
            patientGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient group not found with id: " + id))
        );
    }
} 