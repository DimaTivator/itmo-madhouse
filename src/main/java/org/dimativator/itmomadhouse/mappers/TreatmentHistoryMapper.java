package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.TreatmentHistoryDto;
import org.dimativator.itmomadhouse.model.TreatmentHistory;

public class TreatmentHistoryMapper {
    public static TreatmentHistoryDto toDto(TreatmentHistory treatmentHistory) {
        return TreatmentHistoryDto.builder()
                .id(treatmentHistory.getId())
                .patient(PatientMapper.toDto(treatmentHistory.getPatient()))
                .doctor(DoctorMapper.toDto(treatmentHistory.getDoctor()))
                .artifact(ArtifactMapper.toDto(treatmentHistory.getArtifact()))
                .creature(CreatureMapper.toDto(treatmentHistory.getCreature()))
                .spell(SpellMapper.toDto(treatmentHistory.getSpell()))
                .treatmentDate(treatmentHistory.getTreatmentDate())
                .loggedAt(treatmentHistory.getLoggedAt())
                .build();
    }

    public static TreatmentHistory toEntity(TreatmentHistoryDto treatmentHistoryDto) {
        return TreatmentHistory.builder()
                .id(treatmentHistoryDto.getId())
                .patient(PatientMapper.toEntity(treatmentHistoryDto.getPatient()))
                .doctor(DoctorMapper.toEntity(treatmentHistoryDto.getDoctor()))
                .artifact(ArtifactMapper.toEntity(treatmentHistoryDto.getArtifact()))
                .creature(CreatureMapper.toEntity(treatmentHistoryDto.getCreature()))
                .spell(SpellMapper.toEntity(treatmentHistoryDto.getSpell()))
                .treatmentDate(treatmentHistoryDto.getTreatmentDate())
                .build();
    }
}
