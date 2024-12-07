package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.DischargeReportDto;
import org.dimativator.itmomadhouse.model.DischargeReport;

public class DischargeReportMapper {
    public static DischargeReportDto toDto(DischargeReport dischargeReport) {
        return DischargeReportDto.builder()
            .id(dischargeReport.getId())
            .patient(PatientMapper.toDto(dischargeReport.getPatient()))
            .doctor(DoctorMapper.toDto(dischargeReport.getDoctor()))
            .report(dischargeReport.getReport())
            .build();
    }

    public static DischargeReport toEntity(DischargeReportDto dischargeReportDto) {
        return DischargeReport.builder()
            .id(dischargeReportDto.getId())
            .patient(PatientMapper.toEntity(dischargeReportDto.getPatient()))
            .doctor(DoctorMapper.toEntity(dischargeReportDto.getDoctor()))
            .report(dischargeReportDto.getReport())
            .build();
    }
}
