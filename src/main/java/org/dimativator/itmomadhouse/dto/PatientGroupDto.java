package org.dimativator.itmomadhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientGroupDto {
    private Long id;
    private DoctorDto doctor;
    private String specialisation;

    private List<PatientDto> patients;
}
