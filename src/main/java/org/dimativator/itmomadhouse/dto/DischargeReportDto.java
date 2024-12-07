package org.dimativator.itmomadhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DischargeReportDto {
    private Long id;
    private PatientDto patient;
    private DoctorDto doctor;
    private String report;
}
