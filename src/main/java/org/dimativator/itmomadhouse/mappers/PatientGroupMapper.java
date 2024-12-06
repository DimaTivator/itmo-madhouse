package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.PatientGroupDto;
import org.dimativator.itmomadhouse.model.PatientGroup;

public class PatientGroupMapper {
    public static PatientGroup toEntity(PatientGroupDto groupDto) {
        return PatientGroup.builder()
                .id(groupDto.getId())
                .doctor(DoctorMapper.toEntity(groupDto.getDoctor()))
                .specialisation(groupDto.getSpecialisation())
                .build();
    }

    public static PatientGroupDto toDto(PatientGroup group) {
        return PatientGroupDto.builder()
                .id(group.getId())
                .doctor(DoctorMapper.toDto(group.getDoctor()))
                .specialisation(group.getSpecialisation())
                .build();
    }
} 