package org.dimativator.itmomadhouse.services;

import lombok.RequiredArgsConstructor;
import org.dimativator.itmomadhouse.dto.DoctorDto;
import org.dimativator.itmomadhouse.dto.PatientDto;
import org.dimativator.itmomadhouse.dto.PatientGroupDto;
import org.dimativator.itmomadhouse.model.Patient;
import org.dimativator.itmomadhouse.model.PatientGroup;
import org.dimativator.itmomadhouse.repository.DoctorRepository;
import org.dimativator.itmomadhouse.repository.PatientGroupRepository;
import org.dimativator.itmomadhouse.repository.PatientRepository;
import org.dimativator.itmomadhouse.mappers.DoctorMapper;
import org.dimativator.itmomadhouse.mappers.PatientGroupMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PatientGroupRepository patientGroupRepository;
    private final PatientRepository patientRepository;

    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAll().stream()
            .map(DoctorMapper::toDto)
            .toList();
    }

    @Transactional
    public PatientGroupDto createPatientGroup(DoctorDto doctor, List<PatientDto> patients, String specialisation) {
        // Create and save the group first
        PatientGroupDto groupDto = PatientGroupDto.builder()
            .doctor(doctor)
            .specialisation(specialisation)
            .build();

        PatientGroup savedGroup = patientGroupRepository.save(
            PatientGroupMapper.toEntity(groupDto)
        );

        // Update each patient with the new group
        patients.forEach(patientDto -> {
            Patient patient = patientRepository.findById(patientDto.getId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientDto.getId()));
            patient.setPatientGroup(savedGroup);
            patientRepository.save(patient);
        });

        // Fetch the updated group with patients
        return PatientGroupMapper.toDto(
            patientGroupRepository.findById(savedGroup.getId())
                .orElseThrow(() -> new RuntimeException("Group not found after creation"))
        );
    }
} 