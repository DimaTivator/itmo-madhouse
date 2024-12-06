package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.DoctorDto;
import org.dimativator.itmomadhouse.model.Doctor;

public class DoctorMapper {
    public static Doctor toEntity(DoctorDto doctorDto) {
        return Doctor.builder()
                .id(doctorDto.getId())
                .name(doctorDto.getName())
                .dateOfBirth(doctorDto.getDateOfBirth())
                .specialisation(doctorDto.getSpecialisation())
                .faculty(FacultyMapper.toEntity(doctorDto.getFaculty()))
                .user(UserMapper.toEntity(doctorDto.getUser()))
                .build();
    }

    public static DoctorDto toDto(Doctor doctor) {
        return DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .dateOfBirth(doctor.getDateOfBirth())
                .specialisation(doctor.getSpecialisation())
                .faculty(FacultyMapper.toDto(doctor.getFaculty()))
                .user(UserMapper.toDto(doctor.getUser()))
                .build();
    }
} 