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
} 