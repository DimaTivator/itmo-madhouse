package org.dimativator.itmomadhouse.mappers;

import org.dimativator.itmomadhouse.dto.AppointmentDto;
import org.dimativator.itmomadhouse.model.Appointment;

public class AppointmentMapper {
    public static Appointment toEntity(AppointmentDto appointmentDto) {
        return Appointment.builder()
                .id(appointmentDto.getId())
                .patient(PatientMapper.toEntity(appointmentDto.getPatient()))
                .doctor(DoctorMapper.toEntity(appointmentDto.getDoctor()))
                .appointmentDate(appointmentDto.getAppointmentDate())
                .status(appointmentDto.getStatus())
                .notes(appointmentDto.getNotes())
                .build();
    }

    public static AppointmentDto toDto(Appointment appointment) {
        return AppointmentDto.builder()
                .id(appointment.getId())
                .patient(PatientMapper.toDto(appointment.getPatient()))
                .doctor(DoctorMapper.toDto(appointment.getDoctor()))
                .appointmentDate(appointment.getAppointmentDate())
                .status(appointment.getStatus())
                .notes(appointment.getNotes())
                .build();
    }
} 