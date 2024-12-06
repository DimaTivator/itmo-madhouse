package org.dimativator.itmomadhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentDto {
    private Long id;
    private PatientDto patient;
    private DoctorDto doctor;
    private ArtifactDto artifact;
    private CreatureDto creature;
    private SpellDto spell;
    private java.time.LocalDate date;
} 