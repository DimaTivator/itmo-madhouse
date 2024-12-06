package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.TreatmentDto;
import org.dimativator.itmomadhouse.model.Treatment;

public class TreatmentMapper {
    public static Treatment toEntity(TreatmentDto treatmentDto) {
        return Treatment.builder()
                .id(treatmentDto.getId())
                .patient(PatientMapper.toEntity(treatmentDto.getPatient()))
                .doctor(DoctorMapper.toEntity(treatmentDto.getDoctor()))
                .artifact(ArtifactMapper.toEntity(treatmentDto.getArtifact()))
                .creature(CreatureMapper.toEntity(treatmentDto.getCreature()))
                .spell(SpellMapper.toEntity(treatmentDto.getSpell()))
                .date(treatmentDto.getDate())
                .build();
    }

    public static TreatmentDto toDto(Treatment treatment) {
        return TreatmentDto.builder()
                .id(treatment.getId())
                .patient(PatientMapper.toDto(treatment.getPatient()))
                .doctor(DoctorMapper.toDto(treatment.getDoctor()))
                .artifact(ArtifactMapper.toDto(treatment.getArtifact()))
                .creature(CreatureMapper.toDto(treatment.getCreature()))
                .spell(SpellMapper.toDto(treatment.getSpell()))
                .date(treatment.getDate())
                .build();
    }
} 