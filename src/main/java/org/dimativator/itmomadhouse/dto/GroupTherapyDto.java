package org.dimativator.itmomadhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupTherapyDto {
    private Long id;
    private PatientGroupDto patientGroup;
    private ArtifactDto artifact;
    private CreatureDto creature;
    private SpellDto spell;
    private java.time.LocalDate therapyDate;
}
