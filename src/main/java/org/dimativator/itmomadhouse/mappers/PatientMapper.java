package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.PatientDto;
import org.dimativator.itmomadhouse.model.Patient;

public class PatientMapper {
    public static Patient toEntity(PatientDto patientDto) {
        return Patient.builder()
                .id(patientDto.getId())
                .name(patientDto.getName())
                .dateOfBirth(patientDto.getDateOfBirth())
                .doctor(DoctorMapper.toEntity(patientDto.getDoctor()))
                .disease(DiseaseMapper.toEntity(patientDto.getDisease()))
                .patientGroup(PatientGroupMapper.toEntity(patientDto.getPatientGroup()))
                .user(UserMapper.toEntity(patientDto.getUser()))
                .build();
    }

    public static PatientDto toDto(Patient patient) {
        return PatientDto.builder()
                .id(patient.getId())
                .name(patient.getName())
                .dateOfBirth(patient.getDateOfBirth())
                .doctor(DoctorMapper.toDto(patient.getDoctor()))
                .disease(DiseaseMapper.toDto(patient.getDisease()))
                .patientGroup(PatientGroupMapper.toDto(patient.getPatientGroup()))
                .user(UserMapper.toDto(patient.getUser()))
                .build();
    }
} 