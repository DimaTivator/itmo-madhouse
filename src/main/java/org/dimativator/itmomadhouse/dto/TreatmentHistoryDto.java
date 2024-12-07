package org.dimativator.itmomadhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentHistoryDto {
    private Long id;
    private PatientDto patient;
    private DoctorDto doctor;
    private ArtifactDto artifact;
    private CreatureDto creature;
    private SpellDto spell;
    private LocalDateTime treatmentDate;
    private LocalDateTime loggedAt;
}
