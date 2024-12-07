package org.dimativator.itmomadhouse.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssignTherapyRequest {
    private Long patientId;
    private Long doctorId;
    private Long artifactId;
    private Long spellId;
    private Long creatureId;
    private LocalDate treatmentDate;
} 