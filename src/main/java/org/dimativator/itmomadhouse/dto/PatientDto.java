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
public class PatientDto {
    private Long id;
    private String name;
    private java.time.LocalDate dateOfBirth;
    // private DoctorDto doctor;
    private DiseaseDto disease;
    private PatientGroupDto patientGroup;
    private UserDto user;

    // private List<TreatmentDto> treatments;
} 