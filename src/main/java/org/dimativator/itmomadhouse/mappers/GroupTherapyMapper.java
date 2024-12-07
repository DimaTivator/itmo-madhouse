package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.GroupTherapyDto;
import org.dimativator.itmomadhouse.model.GroupTherapy;

public class GroupTherapyMapper {
    public static GroupTherapy toEntity(GroupTherapyDto groupTherapyDto) {
        return GroupTherapy.builder()
            .id(groupTherapyDto.getId())
            .patientGroup(PatientGroupMapper.toEntity(groupTherapyDto.getPatientGroup()))
            .artifact(ArtifactMapper.toEntity(groupTherapyDto.getArtifact()))
            .creature(CreatureMapper.toEntity(groupTherapyDto.getCreature()))
            .spell(SpellMapper.toEntity(groupTherapyDto.getSpell()))
            .therapyDate(groupTherapyDto.getTherapyDate())
            .build();
    }

    public static GroupTherapyDto toDto(GroupTherapy groupTherapy) {
        return GroupTherapyDto.builder()
            .id(groupTherapy.getId())
            .patientGroup(PatientGroupMapper.toDto(groupTherapy.getPatientGroup()))
            .artifact(ArtifactMapper.toDto(groupTherapy.getArtifact()))
            .creature(CreatureMapper.toDto(groupTherapy.getCreature()))
            .spell(SpellMapper.toDto(groupTherapy.getSpell()))
            .therapyDate(groupTherapy.getTherapyDate())
            .build();
    }
}
